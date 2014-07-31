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
package sius.unit.composition.speed;

public final class SpeedFactory {

	private SpeedFactory() {
		// private constructor to prevent instantiation
	}

	private static MeterPerSecond mps = new MeterPerSecondImpl(0);
	public static MeterPerSecond mps(double d) {
		return mps.valueOf(d);
	}

	public static MilesPerHour mph = new MilesPerHourImpl(0);
	public static MilesPerHour mph(double d) {
		return mph.valueOf(d);
	}
}