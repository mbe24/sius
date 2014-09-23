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
import org.beyene.sius.dimension.Temperature;
import org.beyene.sius.unit.UnitIdentifier;
import org.beyene.sius.unit.temperature.Celsius;
import org.beyene.sius.unit.temperature.Constants;
import org.beyene.sius.unit.temperature.Kelvin;
import org.beyene.sius.util.Preferences;

final class CelsiusImpl extends AbstractUnit<Temperature, Kelvin, Celsius> implements Celsius {

	private static final transient Cache<Temperature, Kelvin, Celsius> dynamicCache;
	private static final transient StaticCache<Temperature, Kelvin, Celsius> staticCache;
	
	static {
		int sizeDyn = Preferences.getInt("celsius.cache.dynamic.size", 0);
		if (sizeDyn > 0)
			dynamicCache = Caches.newInstance(UnitIdentifier.CELSIUS, Math.abs((sizeDyn)));
		else
			dynamicCache = null;

		int sizeStatic = Preferences.getInt("celsius.cache.static.size", 1);
		if (sizeStatic > 0)
			staticCache = new StaticCache<Temperature, Kelvin, Celsius>(Preferences.getInt("celsius.cache.static.low", 0), sizeStatic, CelsiusImpl.class);
		else
			staticCache = null;
	}
	
	public CelsiusImpl(double value) {
		super(value, Temperature.INSTANCE, UnitIdentifier.CELSIUS, Celsius.class, dynamicCache, staticCache);
	}

	@Override
	public Celsius fromBase(Kelvin base) {
		return valueOf(base.getValue() - Constants.CELSIUS_KELVIN_OFFSET);
	}
	
	@Override
	public Kelvin toBase() {
		return FactoryTemperature.kelvin(value + Constants.CELSIUS_KELVIN_OFFSET);
	}

	@Override
	protected Celsius _this() {
		return this;
	}

	@Override
	protected Celsius _new_instance(double value) {
		return new CelsiusImpl(value);
	}
}