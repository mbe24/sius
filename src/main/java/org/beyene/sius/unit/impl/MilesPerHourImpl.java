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
import org.beyene.sius.unit.UnitId;
import org.beyene.sius.unit.UnitIdentifier;
import org.beyene.sius.unit.composition.speed.Constants;
import org.beyene.sius.unit.composition.speed.MeterPerSecond;
import org.beyene.sius.unit.composition.speed.MilesPerHour;
import org.beyene.sius.unit.length.Meter;
import org.beyene.sius.unit.length.Mile;
import org.beyene.sius.unit.time.Hour;
import org.beyene.sius.unit.time.Second;
import org.beyene.sius.util.Preferences;

import java.util.Locale;

final class MilesPerHourImpl extends AbstractUnit<Speed, MeterPerSecond, MilesPerHour> implements MilesPerHour {

	private static final transient Cache<Speed, MeterPerSecond, MilesPerHour> dynamicCache;
	private static final transient StaticCache<Speed, MeterPerSecond, MilesPerHour> staticCache;
	
	static {
		int sizeDyn = Preferences.getInt("mph.cache.dynamic.size", 0);
		if (sizeDyn > 0)
			dynamicCache = Caches.newInstance(UnitIdentifier.MILES_PER_HOUR, Math.abs((sizeDyn)));
		else
			dynamicCache = null;

		int sizeStatic = Preferences.getInt("mph.cache.static.size", 1);
		if (sizeStatic > 0)
			staticCache = new StaticCache<Speed, MeterPerSecond, MilesPerHour>(Preferences.getInt("mph.cache.static.low", 0), sizeStatic, MilesPerHourImpl.class);
		else
			staticCache = null;
	}
	
	public MilesPerHourImpl(double value) {
		super(value, Speed.INSTANCE, UnitIdentifier.MILES_PER_HOUR, MilesPerHour.class, dynamicCache, staticCache);
	}

	@Override
	public String toString(){
		return String.format(Locale.US, "%2.1f mph", value);
	}

	@Override
	public UnitId<Length, Meter, Mile> getComponentUnit1Id() {
		return UnitIdentifier.MILE;
	}

	@Override
	public UnitId<Time, Second, Hour> getComponentUnit2Id() {
		return UnitIdentifier.HOUR;
	}

	@Override
	public MilesPerHour fromBase(MeterPerSecond base) {
		return valueOf(base.getValue() / Constants.MPS_PER_MPH);
	}

	@Override
	public MeterPerSecond toBase() {
		return FactorySpeed.mps(value * Constants.MPS_PER_MPH);
	}

	@Override
	protected MilesPerHour _this() {
		return this;
	}

	@Override
	protected MilesPerHour _new_instance(double value) {
		return new MilesPerHourImpl(value);
	}
}