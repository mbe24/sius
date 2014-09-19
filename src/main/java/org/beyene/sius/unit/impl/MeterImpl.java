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
import org.beyene.sius.cache.Caches;
import org.beyene.sius.dimension.Length;
import org.beyene.sius.unit.AbstractUnit;
import org.beyene.sius.unit.Unit;
import org.beyene.sius.unit.UnitIdentifier;
import org.beyene.sius.unit.length.Meter;
import org.beyene.sius.util.Preferences;

final class MeterImpl extends AbstractUnit<Length, Meter, Meter> implements Meter {

	private static final transient Cache<Length, Meter, Meter> dynamicCache;
	private static final transient StaticCache<Length, Meter, Meter> staticCache;
	
	static {
		int sizeDyn = Preferences.loadInt("meter.cache.dynamic.size", 0);
		if (sizeDyn > 0)
			dynamicCache = Caches.newInstance(UnitIdentifier.METER, Math.abs((sizeDyn)));
		else
			dynamicCache = null;

		int sizeStatic = Preferences.loadInt("meter.cache.static.size", 0);
		if (sizeStatic > 0)
			staticCache = new StaticCache<>(Preferences.loadInt("meter.cache.static.low", 0), sizeStatic, MeterImpl.class);
		else
			staticCache = null;
	}

	public MeterImpl(double value) {
		super(Length.INSTANCE, UnitIdentifier.METER, UnitIdentifier.METER, Meter.class, value);
	}

	@Override
	public Meter toBaseUnit() {
		return this;
	}

	@Override
	protected Meter fromBase(Unit<Length, Meter, ?> base) {
		return valueOf(base.getValue());
	}

	@Override
	protected Meter _this() {
		return this;
	}

	@Override
	protected Meter _new_instance(double value) {
		return new MeterImpl(value);
	}

	@Override
	protected Meter[] _static_cache() {
		return staticCache.cache;
	}

	@Override
	protected int _static_cache_low() {
		return staticCache.low;
	}

	@Override
	protected int _static_cache_high() {
		return staticCache.high;
	}

	@Override
	protected Cache<Length, Meter, Meter> _dynamic_cache() {
		return dynamicCache;
	}
}