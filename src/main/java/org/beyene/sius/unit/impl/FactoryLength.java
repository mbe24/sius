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

import org.beyene.sius.unit.length.Foot;
import org.beyene.sius.unit.length.Inch;
import org.beyene.sius.unit.length.Meter;
import org.beyene.sius.unit.length.Mile;
import org.beyene.sius.unit.length.Yard;

public final class FactoryLength {
	private FactoryLength() {
		// private constructor to prevent instantiation
	}

	private static Meter meter = new MeterImpl(0);
	public static Meter meter(double d) {
		return meter.valueOf(d);
	}

	public static Mile mile(double d) {
		return new MileImpl(d);
	}
	
	public static Yard yard(double d) {
		return new YardImpl(d);
	}
	
	public static Inch inch(double d) {
		return new InchImpl(d);
	}
	
	public static Foot foot(double d) {
		return new FootImpl(d);
	}
}