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
import org.beyene.sius.dimension.Time;
import org.beyene.sius.unit.UnitIdentifier;
import org.beyene.sius.unit.time.Constants;
import org.beyene.sius.unit.time.Hour;
import org.beyene.sius.unit.time.Second;
import org.beyene.sius.util.Preferences;

final class HourImpl extends AbstractUnit<Time, Second, Hour> implements Hour {

	private static final transient Cache<Time, Second, Hour> dynamicCache;
	private static final transient StaticCache<Time, Second, Hour> staticCache;
	
	static {
		int sizeDyn = Preferences.getInt("hour.cache.dynamic.size", 0);
		if (sizeDyn > 0)
			dynamicCache = Caches.newInstance(UnitIdentifier.HOUR, Math.abs((sizeDyn)));
		else
			dynamicCache = null;

		int sizeStatic = Preferences.getInt("hour.cache.static.size", 1);
		if (sizeStatic > 0)
			staticCache = new StaticCache<>(Preferences.getInt("hour.cache.static.low", 0), sizeStatic, HourImpl.class);
		else
			staticCache = null;
	}
	
	public HourImpl(double value) {
		super(value, Time.INSTANCE, UnitIdentifier.HOUR, HourImpl.class, dynamicCache, staticCache);
	}

	@Override
	public Hour fromBase(Second base) {
		return valueOf(base.getValue() / Constants.SECONDS_PER_HOUR);
	}

	@Override
	public Second toBase() {
		return FactoryTime.second(value * Constants.SECONDS_PER_HOUR);
	}

	@Override
	protected Hour _this() {
		return this;
	}

	@Override
	protected Hour _new_instance(double value) {
		return new HourImpl(value);
	}
}