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
package org.beyene.sius.example;

import org.beyene.sius.operation.Operation;
import org.beyene.sius.unit.UnitIdentifier;
import org.beyene.sius.unit.composition.speed.MeterPerSecond;
import org.beyene.sius.unit.impl.FactoryLength;
import org.beyene.sius.unit.impl.FactorySpeed;
import org.beyene.sius.unit.impl.FactoryTime;
import org.beyene.sius.unit.length.Meter;
import org.beyene.sius.unit.time.Hour;
import org.beyene.sius.unit.time.Minute;

public class CompositeExample {

	public static void main(String[] args) {
		MeterPerSecond speed = FactorySpeed.mps(10);
		Minute time = FactoryTime.minute(1);
		Meter s = Operation.mul(speed, time);

		System.out.println(String.format("Speed \t\t= %s", speed));
		System.out.println(String.format("Time \t\t= %s", time));
		System.out.println(String.format("Distance\t= %s%n", s));
		
		Meter way = FactoryLength.meter(3600);
		Hour duration = FactoryTime.hour(1);
		MeterPerSecond runningSpeed = Operation.div(way, duration, UnitIdentifier.METER_PER_SECOND);
		
		System.out.println(String.format("Distance\t= %s", way));
		System.out.println(String.format("Time \t\t= %s", duration));
		System.out.println(String.format("Speed \t\t= %s", runningSpeed));
	}
}