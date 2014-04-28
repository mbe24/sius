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
package sius.unit;

import sius.dimension.Length;
import sius.dimension.Mass;
import sius.dimension.Temperature;
import sius.dimension.Time;
import sius.unit.length.Meter;
import sius.unit.length.Mile;
import sius.unit.length.Yard;
import sius.unit.mass.KiloGram;
import sius.unit.mass.Pound;
import sius.unit.temperature.Celsius;
import sius.unit.temperature.Fahrenheit;
import sius.unit.temperature.Kelvin;
import sius.unit.time.Second;

/**
 * 
 * @author mbeyene
 *
 */
public final class UnitIdentifier {

	private UnitIdentifier() {
		// private constructor to prevent instantiation
	}

	/* TODO no anonymous classes since hashCode could produce unpredictable results */
	
	/* length */
	public static final UnitId<Length, Meter, Meter> METER = new UnitId<Length, Meter, Meter>() {};

	public static final UnitId<Length, Meter, Mile> MILE = new UnitId<Length, Meter, Mile>() {};
	
	public static final UnitId<Length, Meter, Yard> YARD = new UnitId<Length, Meter, Yard>() {};

	/* mass */
	public static final UnitId<Mass, KiloGram, KiloGram> KILOGRAM = new UnitId<Mass, KiloGram, KiloGram>() {};
	
	public static final UnitId<Mass, KiloGram, Pound> POUND = new UnitId<Mass, KiloGram, Pound>() {};
	
	/* time */
	public static final UnitId<Time, Second, Second> SECOND = new UnitId<Time, Second, Second>() {};
	
	/* temperature */
	public static final UnitId<Temperature, Kelvin, Kelvin> KELVIN = new UnitId<Temperature, Kelvin, Kelvin>() {};
	
	public static final UnitId<Temperature, Kelvin, Celsius> CELSIUS = new UnitId<Temperature, Kelvin, Celsius>() {};
	
	public static final UnitId<Temperature, Kelvin, Fahrenheit> FAHRENHEIT = new UnitId<Temperature, Kelvin, Fahrenheit>() {};
}