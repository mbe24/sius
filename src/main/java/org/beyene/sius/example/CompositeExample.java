package org.beyene.sius.example;

import org.beyene.sius.operation.Operation;
import org.beyene.sius.unit.composition.speed.MeterPerSecond;
import org.beyene.sius.unit.composition.speed.SpeedFactory;
import org.beyene.sius.unit.length.Meter;
import org.beyene.sius.unit.time.Minute;
import org.beyene.sius.unit.time.TimeFactory;

public class CompositeExample {

	public static void main(String[] args) {
		MeterPerSecond speed = SpeedFactory.mps(10);
		Minute time = TimeFactory.minute(1);
		Meter s = Operation.mul(speed, time);

		System.out.println(String.format("Speed \t\t= %s", speed));
		System.out.println(String.format("Time \t\t= %s", time));
		System.out.println(String.format("Distance\t= %s", s));
	}
}