package example;

import sius.operation.Operation;
import sius.unit.Meter;
import sius.unit.Mile;

public class Example {

	public static void main(String[] args) {
		Meter first = new Meter(1000);
		Mile second = new Mile(1);

		System.out.println("Operator \t= " + first);
		System.out.println("Operator \t= " + second);

		System.out.println("SUM \t\t= " + Operation.add(first, second));
		System.out.println("SUM \t\t= " + Operation.add(second, first));
	}
}