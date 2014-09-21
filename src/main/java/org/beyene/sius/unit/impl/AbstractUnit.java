/*
 * Copyright 2014 Mikael Beyene
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * 
 */
package org.beyene.sius.unit.impl;

import org.beyene.sius.cache.Cache;
import org.beyene.sius.dimension.Dimension;
import org.beyene.sius.unit.Unit;
import org.beyene.sius.unit.UnitId;

public abstract class AbstractUnit<D extends Dimension<D>, BASE extends Unit<D, BASE, BASE>, SELF extends Unit<D, BASE, SELF>>
		implements Unit<D, BASE, SELF> {

	protected final double value;

	private final D dimension;
	private final UnitId<D, BASE, SELF> unitId;

	private final Class<? extends SELF> interfaceClass;
	
	private transient final Cache<D, BASE, SELF> dynamicCache;
	private transient final StaticCache<D, BASE, SELF> staticCache;
	
	public AbstractUnit(
			double value,
			D dimension,
			UnitId<D, BASE, SELF> unitId,
			Class<? extends SELF> interfaceClass,
			Cache<D, BASE, SELF> dynamicCache,
			StaticCache<D, BASE, SELF> staticCache
			) {
		this.value = value;
		
		this.dimension = dimension;
		this.unitId = unitId;
		
		this.interfaceClass = interfaceClass;
		
		this.dynamicCache = dynamicCache;
		this.staticCache = staticCache;
	}

	@Override
	public D getDimension() {
		return dimension;
	}

	@Override
	public UnitId<D, BASE, SELF> getIdentifier() {
		return unitId;
	}

	@Override
	public abstract SELF fromBase(BASE base);

	@Override
	public abstract BASE toBase();

	@Override
	public SELF valueOf(double d) {
		if (value == d)
			return _this();

		if (_has_static_cache() && (d == Math.floor(d)) && !Double.isInfinite(d)) {
			int i = (int) d;
			if (i >= staticCache.low && i <= staticCache.high)
				return staticCache.cache[i + (-staticCache.low)];
		}

		if (_has_dynamic_cache()) {
			SELF cached = dynamicCache.lookUp(d);
			if (cached != null)
				return cached;
			else
				cached = _new_instance(d);
			dynamicCache.put(cached);
			return cached;
		}

		return _new_instance(d);
	}

	@Override
	public double getValue() {
		return value;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((interfaceClass == null) ? 0 : interfaceClass.getName().hashCode());
		long temp;
		temp = Double.doubleToLongBits(value);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!interfaceClass.isAssignableFrom(obj.getClass()))
			return false;
		SELF other = interfaceClass.cast(obj);
		if (Double.doubleToLongBits(value) != Double.doubleToLongBits(other.getValue()))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return interfaceClass.getSimpleName() + " [value=" + value + "]";
	}

	protected abstract SELF _this();

	protected abstract SELF _new_instance(double value);

	private boolean _has_static_cache() {
		return staticCache != null;
	}

	private boolean _has_dynamic_cache() {
		return dynamicCache != null;
	}
}