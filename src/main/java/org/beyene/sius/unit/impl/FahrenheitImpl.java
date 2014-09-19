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

import org.beyene.sius.dimension.Temperature;
import org.beyene.sius.operation.Operation;
import org.beyene.sius.unit.Unit;
import org.beyene.sius.unit.UnitId;
import org.beyene.sius.unit.UnitIdentifier;
import org.beyene.sius.unit.temperature.Constants;
import org.beyene.sius.unit.temperature.Fahrenheit;
import org.beyene.sius.unit.temperature.Kelvin;

final class FahrenheitImpl implements Fahrenheit {

	private final double scalar;
	private static final UnitId<Temperature, Kelvin, Fahrenheit> unitId = UnitIdentifier.FAHRENHEIT;
	
	public FahrenheitImpl(double scalar) {
		this.scalar = scalar;
	}

	@Override
	public Temperature getDimension() {
		return Temperature.INSTANCE;
	}

	@Override
	public UnitId<Temperature, Kelvin, Fahrenheit> getIdentifier() {
		return unitId ;
	}

	@Override
	public <OTHER extends Unit<Temperature, Kelvin, OTHER>> Fahrenheit convert(OTHER other) {
		Fahrenheit converted;
		if (other.getIdentifier().equals(unitId))
			converted = FactoryTemperature.fahrenheit(other.getValue());
		else if (other.getIdentifier().equals(UnitIdentifier.KELVIN))
			converted = FactoryTemperature.fahrenheit((other.getValue()
					* (Constants.FAHRENHEIT_KELVIN_SCALE_NINE / Constants.FAHRENHEIT_KELVIN_SCALE_FIVE))
					- Constants.FAHRENHEIT_KELVIN_OFFSET);
		else
			converted = Operation.convert(other, unitId);
		return converted;
	}

	@Override
	public Kelvin toBaseUnit() {
		return FactoryTemperature.kelvin((scalar +  Constants.FAHRENHEIT_KELVIN_OFFSET)
				* (Constants.FAHRENHEIT_KELVIN_SCALE_FIVE / Constants.FAHRENHEIT_KELVIN_SCALE_NINE));
	}

	@Override
	public Fahrenheit valueOf(double d) {
		return FactoryTemperature.fahrenheit(d);
	}

	@Override
	public double getValue() {
		return scalar;
	}

	@Override
	public String toString() {
		return "Fahrenheit [value=" + scalar + "]";
	}
}