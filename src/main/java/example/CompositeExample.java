package example;

import sius.operation.Operation;
import sius.unit.composition.speed.MeterPerSecond;
import sius.unit.composition.speed.SpeedFactory;
import sius.unit.length.Meter;
import sius.unit.time.Minute;
import sius.unit.time.TimeFactory;

public class CompositeExample {

	public static void main(String[] args) {
	MeterPerSecond speed = SpeedFactory.mps(10);
	Minute time = TimeFactory.minute(1);
	
	Meter s = Operation.mul(speed, time);

	}

}
