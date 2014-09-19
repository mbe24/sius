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
package org.beyene.sius.unit;

import org.beyene.sius.cache.Cache;
import org.beyene.sius.dimension.Dimension;
import org.beyene.sius.operation.Operation;
import org.beyene.sius.unit.impl.StaticCache;

public abstract class AbstractUnit<D extends Dimension<D>, BASE extends Unit<D, BASE, BASE>, SELF extends Unit<D, BASE, SELF>>
		implements Unit<D, BASE, SELF> {

	protected final double value;

	private final D dimension;
	private final UnitId<D, BASE, BASE> baseId;
	private final UnitId<D, BASE, SELF> unitId;

	private final Class<? extends Unit<D, BASE, SELF>> interfaceClass;

	public AbstractUnit(D dimension, UnitId<D, BASE, BASE> baseId,
			UnitId<D, BASE, SELF> unitId,
			Class<? extends Unit<D, BASE, SELF>> interfaceClass, double value) {
		this.dimension = dimension;
		this.baseId = baseId;
		this.unitId = unitId;
		this.interfaceClass = interfaceClass;
		this.value = value;
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
	public <OTHER extends Unit<D, BASE, OTHER>> SELF convert(OTHER other) {
		SELF converted;
		if (other.getIdentifier().equals(unitId))
			converted = valueOf(other.getValue());
		else if (other.getIdentifier().equals(baseId))
			converted = fromBase(other);
		else
			converted = Operation.convert(other, unitId);
		return converted;
	}

	protected abstract SELF fromBase(Unit<D, BASE, ?> base);

	@Override
	public abstract BASE toBaseUnit();

	@Override
	public SELF valueOf(double d) {
		if (value == d)
			return _this();

		if (_has_static_cache() && (d == Math.floor(d)) && !Double.isInfinite(d)) {
			StaticCache<D, BASE, SELF> cache = _static_cache();
			int i = (int) d;
			if (i >= cache.low && i <= cache.high)
				return cache.cache[i + (-cache.low)];
		}

		if (_has_dynamic_cache()) {
			SELF cached = _dynamic_cache().lookUp(d);
			if (cached != null)
				return cached;
			else
				cached = _new_instance(d);
			_dynamic_cache().put(cached);
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
		Unit<D, BASE, SELF> other = interfaceClass.cast(obj);
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

	protected abstract StaticCache<D, BASE, SELF> _static_cache();

	private boolean _has_static_cache() {
		return _static_cache() != null;
	}

	protected abstract Cache<D, BASE, SELF> _dynamic_cache();

	private boolean _has_dynamic_cache() {
		return _dynamic_cache() != null;
	}
}