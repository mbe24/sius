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
import org.beyene.sius.unit.length.Meter;
import org.beyene.sius.unit.length.Yard;
import org.beyene.sius.util.Preferences;

final class YardImpl extends AbstractUnit<Length, Meter, Yard> implements Yard {

	private static final transient Cache<Length, Meter, Yard> dynamicCache;
	private static final transient StaticCache<Length, Meter, Yard> staticCache;
	
	static {
		int sizeDyn = Preferences.getInt("yard.cache.dynamic.size", 0);
		if (sizeDyn > 0)
			dynamicCache = Caches.newInstance(UnitIdentifier.YARD, Math.abs((sizeDyn)));
		else
			dynamicCache = null;

		int sizeStatic = Preferences.getInt("yard.cache.static.size", 1);
		if (sizeStatic > 0)
			staticCache = new StaticCache<Length, Meter, Yard>(Preferences.getInt("yard.cache.static.low", 0), sizeStatic, YardImpl.class);
		else
			staticCache = null;
	}

	public YardImpl(double value) {
		super(value, Length.INSTANCE, UnitIdentifier.YARD, YardImpl.class, dynamicCache, staticCache);
	}

	@Override
	public String getUnitSymbol(){
		return "yd";
	}

	@Override
	public Yard fromBase(Meter base) {
		return valueOf((base.getValue() / Constants.METER_PER_YARD));
	}
	
	@Override
	public Meter toBase() {
		return FactoryLength.meter(value * Constants.METER_PER_YARD);
	}

	@Override
	protected Yard _this() {
		return this;
	}

	@Override
	protected Yard _new_instance(double value) {
		return new YardImpl(value);
	}
}