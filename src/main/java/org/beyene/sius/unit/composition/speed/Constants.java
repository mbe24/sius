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
package org.beyene.sius.unit.composition.speed;

import static org.beyene.sius.unit.length.Constants.METER_PER_FOOT;

public final class Constants {
	private Constants() {
		// private constructor to prevent instantiation
	}
	
	public static final double MPS_PER_MPH = 0.44704;

    public static final double MPS_PER_FTPS = METER_PER_FOOT;
}
