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
package sius.operation;

import sius.dimension.Dimension;
import sius.operation.functor.Adder;
import sius.operation.functor.FunctorFactory;
import sius.unit.Unit;
import sius.unit.UnitId;

/**
 * 
 * @author mbeyene
 * 
 */
public final class Operation {

	private Operation() {
		// private constructor to prevent instantiation
	}

	/**
	 * Converts a unit into another unit of same dimension.
	 * 
	 * @param op unit to convert
	 * @param cunitId identifier of new unit
	 * @return value of <code>op</code> converted to new unit.
	 */
	public static <D extends Dimension<D>, B extends Unit<D, B, B>, OP extends Unit<D, B, OP>, CU extends Unit<D, B, CU>, CuId extends UnitId<D, B, CU>> CU convert(OP op, CuId cunitId) {
		return Converter.convert(op, cunitId);
	}

	/**
	 * Adds (different) units of the same dimension. Result is of same type as first operand.
	 * 
	 * @param op1 first operand. Determines type of result.
	 * @param op2 second operand. Gets added to first operand.
	 * @return sum
	 */
	public static <D extends Dimension<D>, B extends Unit<D, B, B>, OP1 extends Unit<D, B, OP1>, OP2 extends Unit<D, B, OP2>> OP1 add(
			OP1 op1, OP2 op2) {
		return op1.valueOf(op1.getScalar() + op1.convert(op2).getScalar());
	}
	
	/**
	 * Adds (different) units of the same dimension. Result is of same type as first operand.
	 * 
	 * @param op1 first operand. Determines type of result.
	 * @param op2 second operand. Gets added to first operand.
	 * @return sum
	 */
	public static <D extends Dimension<D>, B extends Unit<D, B, B>, OP1 extends Unit<D, B, OP1>, OP2 extends Unit<D, B, OP2>, OP3 extends Unit<D, B, OP3>> OP1 add(
			OP1 op1, OP2 op2, OP3 op3) {
		return op1.valueOf(op1.getScalar() + op1.convert(op2).getScalar() + op1.convert(op3).getScalar());
	}

	@SafeVarargs
	public static <D extends Dimension<D>, B extends Unit<D, B, B>, OP extends Unit<D, B, OP>, CU extends Unit<D, B, CU>, CUID extends UnitId<D, B, CU>> CU add(CUID cunitId, OP op, Unit<D, B, ?>... ops) {
		Adder<D> adder = FunctorFactory.<D>sum().op(op);
		for (Unit<D, B, ?> o : ops)
			adder.op(o);
		return adder.apply(cunitId);
	}
	
	/**
	 * Subtracts two (different) units of the same dimension. Result is of same type as first operand.
	 * 
	 * @param op1 first operand. Determines type of result.
	 * @param op2 second operand. Gets subtracted from first operand.
	 * @return difference
	 */
	public static <D extends Dimension<D>, B extends Unit<D, B, B>, OP1 extends Unit<D, B, OP1>, OP2 extends Unit<D, B, OP2>> OP1 sub(OP1 op1, OP2 op2) {
		return op1.valueOf(op1.getScalar() - op1.convert(op2).getScalar());
	}

	/**
	 * Scalar multiplication.
	 * 
	 * @param op operand and first factor
	 * @param scalar scalar and second factor
	 * @return product
	 */
	public static <D extends Dimension<D>, B extends Unit<D, B, B>, OP extends Unit<D, B, OP>> OP mul(OP op, double scalar) {
		return op.valueOf(op.getScalar() * scalar);
	}

	/**
	 * Scalar division.
	 * 
	 * @param op dividend
	 * @param scalar divisor
	 * @return quotient
	 */
	public static <D extends Dimension<D>, B extends Unit<D, B, B>, OP extends Unit<D, B, OP>> OP div(OP op, double scalar) {
		// TODO maybe throw exception, since this is java standard
		if (scalar == 0)
			return op.valueOf(op.getScalar());
		else
			return op.valueOf(op.getScalar() / scalar);
	}
}