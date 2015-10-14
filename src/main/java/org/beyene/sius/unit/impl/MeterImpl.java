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
import org.beyene.sius.unit.UnitId;
import org.beyene.sius.unit.UnitIdentifier;
import org.beyene.sius.unit.length.Meter;
import org.beyene.sius.util.Preferences;

import java.util.Locale;

final class MeterImpl extends AbstractUnit<Length, Meter, Meter> implements Meter {

	private static final transient Cache<Length, Meter, Meter> dynamicCache;
	private static final transient StaticCache<Length, Meter, Meter> staticCache;
	
	static {
		int sizeDyn = Preferences.getInt("meter.cache.dynamic.size", 0);
		if (sizeDyn > 0)
			dynamicCache = Caches.newInstance(UnitIdentifier.METER, Math.abs((sizeDyn)));
		else
			dynamicCache = null;

		int sizeStatic = Preferences.getInt("meter.cache.static.size", 1);
		if (sizeStatic > 0)
			staticCache = new StaticCache<Length, Meter, Meter>(Preferences.getInt("meter.cache.static.low", 0), sizeStatic, MeterImpl.class);
		else
			staticCache = null;
	}

	MeterImpl(double value, Length dimension,
			UnitId<Length, Meter, Meter> unitId,
			Class<? extends Meter> interfaceClass,
			Cache<Length, Meter, Meter> dynamicCache,
			StaticCache<Length, Meter, Meter> staticCache) {
		super(value, dimension, unitId, interfaceClass, dynamicCache, staticCache);
	}

	public MeterImpl(double value) {
		super(value, Length.INSTANCE, UnitIdentifier.METER, Meter.class, dynamicCache, staticCache);
	}

	@Override
	public String getUnitSymbol(){
		return "m";
	}

	@Override
	public Meter toBase() {
		return this;
	}

	@Override
	public Meter fromBase(Meter base) {
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
}