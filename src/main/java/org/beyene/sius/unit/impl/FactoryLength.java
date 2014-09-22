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

	private static final Meter meter = new MeterImpl(0).valueOf(0);
	public static Meter meter(double value) {
		return meter.valueOf(value);
	}

	private static final Mile mile = new MileImpl(0).valueOf(0);
	public static Mile mile(double value) {
		return mile.valueOf(value);
	}
	
	private static final Yard yard = new YardImpl(0).valueOf(0);
	public static Yard yard(double value) {
		return yard.valueOf(value);
	}
	
	private static final Inch inch = new InchImpl(0).valueOf(0);
	public static Inch inch(double value) {
		return inch.valueOf(value);
	}
	
	private static final Foot foot = new FootImpl(0);
	public static Foot foot(double value) {
		return foot.valueOf(value);
	}
}