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

import org.beyene.sius.unit.temperature.Celsius;
import org.beyene.sius.unit.temperature.Fahrenheit;
import org.beyene.sius.unit.temperature.Kelvin;

public final class FactoryTemperature {
	private FactoryTemperature() {
		// private constructor to prevent instantiation
	}
	
	private static final Kelvin kelvin = new KelvinImpl(0).valueOf(0);
	public static Kelvin kelvin(double value) {
		return kelvin.valueOf(value);
	}
	
	private static final Celsius celsius = new CelsiusImpl(0).valueOf(0);
	public static Celsius celsius(double value) {
		return celsius.valueOf(value);
	}
	
	private static final Fahrenheit fahrenheit = new FahrenheitImpl(0).valueOf(0);
	public static Fahrenheit fahrenheit(double value) {
		return fahrenheit.valueOf(value);
	}
}