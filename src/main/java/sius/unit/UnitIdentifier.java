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
import sius.unit.length.Metre;
import sius.unit.length.Mile;
import sius.unit.mass.KiloGram;
import sius.unit.mass.Pound;

public final class UnitIdentifier {

	private UnitIdentifier() {
		// private constructor to prevent instantiation
	}

	/* length */
	public static final UnitId<Length, Metre> METER = new UnitId<Length, Metre>() {};
	public static final UnitId<Length, Mile> MILE = new UnitId<Length, Mile>(){};

	/* mass */
	public static final UnitId<Mass, KiloGram> KILOGRAM = new UnitId<Mass, KiloGram>() {};
	public static final UnitId<Mass, Pound> POUND = new UnitId<Mass, Pound>() {};
}