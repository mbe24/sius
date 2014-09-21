package org.beyene.sius.example;

import org.beyene.sius.operation.Operation;
import org.beyene.sius.unit.UnitIdentifier;
import org.beyene.sius.unit.composition.speed.MeterPerSecond;
import org.beyene.sius.unit.impl.FactoryLength;
import org.beyene.sius.unit.impl.FactorySpeed;
import org.beyene.sius.unit.impl.FactoryTime;
import org.beyene.sius.unit.length.Meter;
import org.beyene.sius.unit.time.Minute;
import org.beyene.sius.unit.time.Second;

public class CompositeExample {

	public static void main(String[] args) {
		MeterPerSecond speed = FactorySpeed.mps(10);
		Minute time = FactoryTime.minute(1);
		Meter s = Operation.mul(speed, time);

		System.out.println(String.format("Speed \t\t= %s", speed));
		System.out.println(String.format("Time \t\t= %s", time));
		System.out.println(String.format("Distance\t= %s%n", s));
		
		Meter way = FactoryLength.meter(100);
		Second duration = FactoryTime.second(15);
		MeterPerSecond runningSpeed = Operation.div(way, duration, UnitIdentifier.METER_PER_SECOND);
		
		System.out.println(String.format("Distance\t= %s", way));
		System.out.println(String.format("Time \t\t= %s", duration));
		System.out.println(String.format("Speed \t\t= %s", runningSpeed));
	}
}