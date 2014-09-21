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

import org.beyene.sius.dimension.Length;
import org.beyene.sius.dimension.Time;
import org.beyene.sius.dimension.composition.Speed;
import org.beyene.sius.unit.Unit;
import org.beyene.sius.unit.composition.FractionUnit;
import org.beyene.sius.unit.length.Meter;
import org.beyene.sius.unit.time.Second;

public interface SpeedUnit<
NUMERATOR extends Unit<Length, Meter, NUMERATOR>, 
DENOMINATOR extends Unit<Time, Second, DENOMINATOR>, 
T extends SpeedUnit<NUMERATOR, DENOMINATOR, T>> extends FractionUnit<
Length, 
Meter, 
NUMERATOR, 
Time, 
Second, 
DENOMINATOR,
Speed, 
MeterPerSecond, 
T> {
	
}
