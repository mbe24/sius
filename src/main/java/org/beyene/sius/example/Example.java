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

import java.util.Arrays;
import java.util.List;

import org.beyene.sius.dimension.Length;
import org.beyene.sius.dimension.Mass;
import org.beyene.sius.operation.Operation;
import org.beyene.sius.operation.functor.Adder;
import org.beyene.sius.operation.functor.ArithmeticMean;
import org.beyene.sius.operation.functor.FunctorFactory;
import org.beyene.sius.unit.Unit;
import org.beyene.sius.unit.UnitIdentifier;
import org.beyene.sius.unit.impl.FactoryLength;
import org.beyene.sius.unit.impl.FactoryMass;
import org.beyene.sius.unit.impl.FactoryTemperature;
import org.beyene.sius.unit.length.Foot;
import org.beyene.sius.unit.length.Inch;
import org.beyene.sius.unit.length.Meter;
import org.beyene.sius.unit.length.Mile;
import org.beyene.sius.unit.mass.KiloGram;
import org.beyene.sius.unit.mass.Pound;
import org.beyene.sius.unit.temperature.Celsius;
import org.beyene.sius.unit.temperature.Fahrenheit;

public class Example {

	public static void main(String[] args) {
		System.out.println("Length example");
		Meter lengthFirst = FactoryLength.meter(1000);
		Mile lengthSecond = FactoryLength.mile(1);

		System.out.println(String.format("Operator \t= %s", lengthFirst));
		System.out.println(String.format("Operator \t= %s", lengthSecond));

		Meter sum1 = Operation.add(lengthFirst, lengthSecond);
		System.out.println("Sum \t\t= " + sum1);

		Mile sum2 = Operation.add(lengthSecond, lengthFirst);
		System.out.println("Sum \t\t= " + sum2);

		System.out.println("\nMass example");
		KiloGram weightFirst = FactoryMass.kg(100);
		Pound weightSecond = FactoryMass.lb(200);

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
		
		Celsius celsius = FactoryTemperature.celsius(0);
		Fahrenheit fahrenheit = Operation.convert(celsius, UnitIdentifier.FAHRENHEIT);
		System.out.println(String.format("Converted %s to %s", celsius, fahrenheit));
		
		Foot foot = FactoryLength.foot(1);
		Inch inch = Operation.convert(foot, UnitIdentifier.INCH);
		System.out.println(String.format("Converted %s to %s", foot, inch));
		
		@SuppressWarnings("unchecked")
		List<Unit<Length, Meter, ?>> lengths = Arrays.<Unit<Length, Meter, ?>>asList(FactoryLength.meter(1000), FactoryLength.mile(1), FactoryLength.meter(1000));
		System.out.println(String.format("Summands \t= %s", lengths.toString()));
		System.out.println("Sum \t\t= " + Operation.add(FactoryLength.meter(1000), FactoryLength.mile(1), FactoryLength.meter(1000)));
		
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
		
		ArithmeticMean<Mass, KiloGram, KiloGram> mean = FunctorFactory.mean(UnitIdentifier.KILOGRAM)
				.op(FactoryMass.kg(10))
				.op(FactoryMass.kg(100))
				.op(FactoryMass.lb(100))
				.op(FactoryMass.lb(100));
		System.out.println(mean);
		System.out.println(mean.apply());
	}
}