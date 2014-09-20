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
import org.beyene.sius.dimension.Time;
import org.beyene.sius.dimension.composition.Speed;
import org.beyene.sius.unit.Unit;
import org.beyene.sius.unit.UnitId;
import org.beyene.sius.unit.UnitIdentifier;
import org.beyene.sius.unit.composition.speed.MeterPerSecond;
import org.beyene.sius.unit.length.Meter;
import org.beyene.sius.unit.time.Second;
import org.beyene.sius.util.Preferences;

final class MeterPerSecondImpl extends AbstractUnit<Speed, MeterPerSecond, MeterPerSecond> implements MeterPerSecond {

	private static final transient Cache<Speed, MeterPerSecond, MeterPerSecond> dynamicCache;
	private static final transient StaticCache<Speed, MeterPerSecond, MeterPerSecond> staticCache;
	
	static {
		int sizeDyn = Preferences.loadInt("mps.cache.dynamic.size", 0);
		if (sizeDyn > 0)
			dynamicCache = Caches.newInstance(UnitIdentifier.METER_PER_SECOND, Math.abs((sizeDyn)));
		else
			dynamicCache = null;

		int sizeStatic = Preferences.loadInt("mps.cache.static.size", 0);
		if (sizeStatic > 0)
			staticCache = new StaticCache<>(Preferences.loadInt("mps.cache.static.low", 0), sizeStatic, MeterPerSecondImpl.class);
		else
			staticCache = null;
	}
	
	public MeterPerSecondImpl(double value) {
		super(value, Speed.INSTANCE, UnitIdentifier.METER_PER_SECOND, MeterPerSecond.class, dynamicCache, staticCache);
	}

	@Override
	public UnitId<Length, Meter, Meter> getComponentUnit1Id() {
		return UnitIdentifier.METER;
	}

	@Override
	public UnitId<Time, Second, Second> getComponentUnit2Id() {
		return UnitIdentifier.SECOND;
	}

	@Override
	protected MeterPerSecond fromBase(Unit<Speed, MeterPerSecond, MeterPerSecond> base) {
		return valueOf(base.getValue());
	}

	@Override
	public MeterPerSecond toBaseUnit() {
		return this;
	}

	@Override
	protected MeterPerSecond _this() {
		return this;
	}

	@Override
	protected MeterPerSecond _new_instance(double value) {
		return new MeterPerSecondImpl(value);
	}
}