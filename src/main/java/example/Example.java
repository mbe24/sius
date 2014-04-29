package example;

import sius.dimension.Length;
import sius.dimension.Mass;
import sius.operation.Operation;
import sius.operation.functor.Adder;
import sius.operation.functor.ArithmeticMean;
import sius.operation.functor.FunctorFactory;
import sius.unit.UnitIdentifier;
import sius.unit.length.Foot;
import sius.unit.length.Inch;
import sius.unit.length.LengthFactory;
import sius.unit.length.Meter;
import sius.unit.length.Mile;
import sius.unit.mass.KiloGram;
import sius.unit.mass.MassFactory;
import sius.unit.mass.Pound;
import sius.unit.temperature.Celsius;
import sius.unit.temperature.Fahrenheit;
import sius.unit.temperature.TemperatureFactory;

public class Example {

	public static void main(String[] args) {
		System.out.println("Length example");
		Meter lengthFirst = LengthFactory.meter(1000);
		Mile lengthSecond = LengthFactory.mile(1);

		System.out.println(String.format("Operator \t= %s", lengthFirst));
		System.out.println(String.format("Operator \t= %s", lengthSecond));

		Meter sum1 = Operation.add(lengthFirst, lengthSecond);
		System.out.println("Sum \t\t= " + sum1);

		Mile sum2 = Operation.add(lengthSecond, lengthFirst);
		System.out.println("Sum \t\t= " + sum2);

		System.out.println("\nMass example");
		KiloGram weightFirst = MassFactory.kg(100);
		Pound weightSecond = MassFactory.lb(200);

		System.out.println(String.format("Operator \t= %s", weightFirst));
		System.out.println(String.format("Operator \t= %s", weightSecond));

		KiloGram sum3 = Operation.add(weightFirst, weightSecond);
		System.out.println("Sum \t\t= " + sum3);

		Pound sum4 = Operation.add(weightSecond, weightFirst);
		System.out.println("Sum \t\t= " + sum4);

		System.out.println("\nConversion example");
		Pound convertedMass = Operation.convert(weightFirst, UnitIdentifier.POUND);
		System.out.println(String.format("Converted %s to %s", weightFirst, convertedMass));
		
		Meter convertedLength = Operation.convert(lengthSecond, UnitIdentifier.METER);
		System.out.println(String.format("Converted %s to %s", lengthSecond, convertedLength));
		
		Celsius celsius = TemperatureFactory.celsius(0);
		Fahrenheit fahrenheit = Operation.convert(celsius, UnitIdentifier.FAHRENHEIT);
		System.out.println(String.format("Converted %s to %s", celsius, fahrenheit));
		
		Foot foot = LengthFactory.foot(1);
		Inch inch = Operation.convert(foot, UnitIdentifier.INCH);
		System.out.println(String.format("Converted %s to %s", foot, inch));
		
		Adder<Length, Meter, Meter> adder = FunctorFactory.sum(UnitIdentifier.METER)
		.op(lengthSecond)
		.op(lengthSecond)
		.op(lengthSecond)
		.op(lengthSecond)
		.op(lengthSecond)
		.op(lengthSecond)
		.op(lengthSecond)
		.op(lengthSecond)
		.op(lengthSecond)
		.op(lengthSecond)
		.op(foot)
		.op(foot);
		System.out.println(adder);
		System.out.println(adder.apply());
		
		Meter sameRes = Operation.add(UnitIdentifier.METER,
				lengthSecond,
				lengthSecond,
				lengthSecond,
				lengthSecond,
				lengthSecond,
				lengthSecond,
				lengthSecond,
				lengthSecond,
				lengthSecond,
				lengthSecond,
				foot,
				foot);
		System.out.println(sameRes);
		
		ArithmeticMean<Mass, KiloGram, KiloGram> mean = FunctorFactory.mean(UnitIdentifier.KILOGRAM)
				.op(MassFactory.kg(10))
				.op(MassFactory.kg(100))
				.op(MassFactory.lb(100))
				.op(MassFactory.lb(100));
		System.out.println(mean);
		System.out.println(mean.apply());
	}
}