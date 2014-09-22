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
import org.beyene.sius.unit.UnitIdentifier;
import org.beyene.sius.unit.length.Constants;
import org.beyene.sius.unit.length.Foot;
import org.beyene.sius.unit.length.Meter;
import org.beyene.sius.util.Preferences;

final class FootImpl extends AbstractUnit<Length, Meter, Foot> implements Foot {

	private static final transient Cache<Length, Meter, Foot> dynamicCache;
	private static final transient StaticCache<Length, Meter, Foot> staticCache;
	
	static {
		int sizeDyn = Preferences.getInt("foot.cache.dynamic.size", 0);
		if (sizeDyn > 0)
			dynamicCache = Caches.newInstance(UnitIdentifier.FOOT, Math.abs((sizeDyn)));
		else
			dynamicCache = null;

		int sizeStatic = Preferences.getInt("foot.cache.static.size", 0);
		if (sizeStatic > 0)
			staticCache = new StaticCache<>(Preferences.getInt("foot.cache.static.low", 0), sizeStatic, FootImpl.class);
		else
			staticCache = null;
	}
	
	public FootImpl(double value) {
		super(value, Length.INSTANCE, UnitIdentifier.FOOT, Foot.class, dynamicCache, staticCache);
	}
	
	@Override
	public Foot fromBase(Meter base) {
		return valueOf(base.getValue() / Constants.METER_PER_FOOT);
	}

	@Override
	public Meter toBase() {
		return FactoryLength.meter(value * Constants.METER_PER_FOOT);
	}

	@Override
	protected Foot _this() {
		return this;
	}

	@Override
	protected Foot _new_instance(double value) {
		return new FootImpl(value);
	}
}