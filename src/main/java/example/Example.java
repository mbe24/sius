package example;

import sius.operation.Operation;
import sius.unit.length.LengthFactory;
import sius.unit.length.Metre;
import sius.unit.length.Mile;
import sius.unit.mass.KiloGram;
import sius.unit.mass.MassFactory;
import sius.unit.mass.Pound;

public class Example {

	public static void main(String[] args) {
		System.out.println("Length example");
		Metre lengthFirst = LengthFactory.meter(1000);
		Mile lengthSecond = LengthFactory.mile(1);

		System.out.println(String.format("Operator \t= %s", lengthFirst));
		System.out.println(String.format("Operator \t= %s", lengthSecond));

		Metre sum1 = Operation.add(lengthFirst, lengthSecond);
		System.out.println("SUM \t\t= " + sum1);
		
		Mile sum2 = Operation.add(lengthSecond, lengthFirst);
		System.out.println("SUM \t\t= " + sum2);
		
		System.out.println("\nMass example");
		KiloGram weightFirst = MassFactory.kg(100);
		Pound weightSecond = MassFactory.lb(200);
		
		System.out.println(String.format("Operator \t= %s", weightFirst));
		System.out.println(String.format("Operator \t= %s", weightSecond));
		
		KiloGram sum3 = Operation.add(weightFirst, weightSecond);
		System.out.println("SUM \t\t= " + sum3);
		
		Pound sum4 = Operation.add(weightSecond, weightFirst);
		System.out.println("SUM \t\t= " + sum4);
	}
}