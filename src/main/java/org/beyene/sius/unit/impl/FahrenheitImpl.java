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
import org.beyene.sius.unit.Unit;
import org.beyene.sius.unit.UnitIdentifier;
import org.beyene.sius.unit.temperature.Constants;
import org.beyene.sius.unit.temperature.Fahrenheit;
import org.beyene.sius.unit.temperature.Kelvin;
import org.beyene.sius.util.Preferences;

final class FahrenheitImpl extends AbstractUnit<Temperature, Kelvin, Fahrenheit> implements Fahrenheit {

	private static final transient Cache<Temperature, Kelvin, Fahrenheit> dynamicCache;
	private static final transient StaticCache<Temperature, Kelvin, Fahrenheit> staticCache;
	
	static {
		int sizeDyn = Preferences.loadInt("fahrenheit.cache.dynamic.size", 0);
		if (sizeDyn > 0)
			dynamicCache = Caches.newInstance(UnitIdentifier.FAHRENHEIT, Math.abs((sizeDyn)));
		else
			dynamicCache = null;

		int sizeStatic = Preferences.loadInt("fahrenheit.cache.static.size", 0);
		if (sizeStatic > 0)
			staticCache = new StaticCache<>(Preferences.loadInt("fahrenheit.cache.static.low", 0), sizeStatic, FahrenheitImpl.class);
		else
			staticCache = null;
	}
	
	public FahrenheitImpl(double value) {
		super(value, Temperature.INSTANCE, UnitIdentifier.FAHRENHEIT, Fahrenheit.class, dynamicCache, staticCache);
	}

	@Override
	protected Fahrenheit fromBase(Unit<Temperature, Kelvin, Kelvin> base) {
		 return valueOf((base.getValue()
		 * (Constants.FAHRENHEIT_KELVIN_SCALE_NINE /
		 Constants.FAHRENHEIT_KELVIN_SCALE_FIVE))
		 - Constants.FAHRENHEIT_KELVIN_OFFSET);
	}

	@Override
	public Kelvin toBaseUnit() {
		return FactoryTemperature.kelvin((value + Constants.FAHRENHEIT_KELVIN_OFFSET)
						* (Constants.FAHRENHEIT_KELVIN_SCALE_FIVE / Constants.FAHRENHEIT_KELVIN_SCALE_NINE));
	}

	@Override
	protected Fahrenheit _this() {
		return this;
	}

	@Override
	protected Fahrenheit _new_instance(double value) {
		return new FahrenheitImpl(value);
	}
}