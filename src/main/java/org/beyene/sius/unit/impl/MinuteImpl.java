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
import org.beyene.sius.unit.time.Minute;
import org.beyene.sius.unit.time.Second;
import org.beyene.sius.util.Preferences;

final class MinuteImpl extends AbstractUnit<Time, Second, Minute> implements Minute {

	private static final transient Cache<Time, Second, Minute>  dynamicCache;
	private static final transient StaticCache<Time, Second, Minute>  staticCache;
	
	static {
		int sizeDyn = Preferences.getInt("minute.cache.dynamic.size", 0);
		if (sizeDyn > 0)
			dynamicCache = Caches.newInstance(UnitIdentifier.MINUTE, Math.abs((sizeDyn)));
		else
			dynamicCache = null;

		int sizeStatic = Preferences.getInt("minute.cache.static.size", 1);
		if (sizeStatic > 0)
			staticCache = new StaticCache<Time, Second, Minute>(Preferences.getInt("minute.cache.static.low", 0), sizeStatic, MinuteImpl.class);
		else
			staticCache = null;
	}
	
	public MinuteImpl(double value) {
		super(value, Time.INSTANCE, UnitIdentifier.MINUTE, Minute.class, dynamicCache, staticCache);
	}

	@Override
	public String getUnitSymbol(){
		return "min";
	}

	@Override
	public Minute fromBase(Second base) {
		return valueOf(base.getValue() / Constants.SECONDS_PER_MINUTE);
	}

	@Override
	public Second toBase() {
		return FactoryTime.second(value * Constants.SECONDS_PER_MINUTE);
	}

	@Override
	protected Minute _this() {
		return this;
	}

	@Override
	protected Minute _new_instance(double value) {
		return new MinuteImpl(value);
	}
}