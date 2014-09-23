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
package org.beyene.sius.operation;

import org.beyene.sius.dimension.Dimension;
import org.beyene.sius.dimension.composition.util.Fraction;
import org.beyene.sius.dimension.composition.util.Product;
import org.beyene.sius.unit.Unit;
import org.beyene.sius.unit.UnitFactory;
import org.beyene.sius.unit.UnitId;
import org.beyene.sius.unit.composition.CompositeUnitId;
import org.beyene.sius.unit.composition.FractionUnit;
import org.beyene.sius.unit.composition.ProductUnit;

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
	 * @param op
	 *            unit to convert
	 * @param targetId
	 *            identifier of new unit
	 * @return value of <code>op</code> converted to new unit.
	 * 
	 * @param <D> dimension
	 * @param <B> base unit of dimension
	 * @param <TARGET_UNIT> target unit
	 */
	public static <D extends Dimension<D>, B extends Unit<D, B, B>, TARGET_UNIT extends Unit<D, B, TARGET_UNIT>> TARGET_UNIT convert(
			Unit<D, B, ?> op, UnitId<D, B, TARGET_UNIT> targetId) {
		return Converter.convert(op, targetId);
	}

	/**
	 * Adds (different) units of the same dimension. Result is of same type as
	 * first operand.
	 * 
	 * @param op1
	 *            first operand. Determines type of result.
	 * @param op2
	 *            second operand. Gets added to first operand.
	 * @return sum
	 * 
	 * @param <D> dimension
	 * @param <B> base unit of dimension
	 * @param <OP1> unit of first operand
	 */
	public static <D extends Dimension<D>, B extends Unit<D, B, B>, OP1 extends Unit<D, B, OP1>> OP1 add(
			Unit<D, B, OP1> op1, Unit<D, B, ?> op2) {
		return op1.valueOf(op1.getValue() + Converter.convert(op2, op1.getIdentifier()).getValue());
	}

	/**
	 * Adds (different) units of the same dimension. Result is of same type as
	 * first operand.
	 * 
	 * @param op1
	 *            first operand. Determines type of result.
	 * @param op2
	 *            second operand. Gets added to first operand.
     * @param op3
	 *            third operand. Gets added to first operand.
	 * @return sum
	 * 
	 * @param <D> dimension
	 * @param <B> base unit of dimension
	 * @param <OP1> unit of first operand
	 */
	public static <D extends Dimension<D>, B extends Unit<D, B, B>, OP1 extends Unit<D, B, OP1>> OP1 add(
			OP1 op1, Unit<D, B, ?> op2, Unit<D, B, ?> op3) {
		return op1.valueOf(op1.getValue() + Converter.convert(op2, op1.getIdentifier()).getValue() 
				+ Converter.convert(op2, op1.getIdentifier()).getValue());
	}


	/**
	 * Subtracts two (different) units of the same dimension. Result is of same
	 * type as first operand.
	 * 
	 * @param op1
	 *            first operand. Determines type of result.
	 * @param op2
	 *            second operand. Gets subtracted from first operand.
	 * @return difference
	 * 
	 * @param <D> dimension
	 * @param <B> base unit of dimension
	 * @param <OP> unit of minuend
	 */
	public static <D extends Dimension<D>, B extends Unit<D, B, B>, OP extends Unit<D, B, OP>> OP sub(
			OP op1, Unit<D, B, ?> op2) {
		return op1.valueOf(op1.getValue() - Converter.convert(op2, op1.getIdentifier()).getValue());
	}

	/**
	 * Scalar multiplication.
	 * 
	 * @param op
	 *            operand and first factor
	 * @param value
	 *            scalar and second factor
	 * @return product
	 * 
	 * @param <D> dimension
	 * @param <B> base unit of dimension
	 * @param <OP> unit of first factor
	 */
	public static <D extends Dimension<D>, B extends Unit<D, B, B>, OP extends Unit<D, B, OP>> OP mul(
			OP op, double value) {
		return op.valueOf(op.getValue() * value);
	}

	/**
	 * Scalar division.
	 * 
	 * @param op
	 *            dividend
	 * @param value
	 *            divisor
	 * @return quotient
	 * 
	 * @param <D> dimension
	 * @param <B> base unit of dimension
	 * @param <OP> unit of dividend
	 */
	public static <D extends Dimension<D>, B extends Unit<D, B, B>, OP extends Unit<D, B, OP>> OP div(
			OP op, double value) {
		return op.valueOf(op.getValue() / value);
	}

	/**
	 * Multiplication of fraction unit and unit.
	 * 
	 * Multiplies a fraction unit of type a/b with a unit of type b.
	 * 
	 * @param factor1
	 *            unit of fraction type
	 * @param factor2
	 *            unit of fraction's denominator dimension
	 * @return unit of fraction's numerator type
	 * 
	 * @param <DIM_NUMERATOR> numerator dimension
	 * @param <BASE_NUMERATOR> base unit of numerator dimension
	 * @param <UNIT_NUMERATOR> unit of numerator dimension
	 * @param <DIM_DENOMINATOR> denominator dimension
	 * @param <BASE_DENOMINATOR> base unit of denominator dimension
	 * @param <UNIT_DENOMINATOR> unit of denominator dimension
	 * @param <DIM_FRACTION> dimension of fraction
	 * @param <BASE_FRACTION> base unit of fraction dimension
	 * @param <UNIT_FRACTION> unit of fraction dimension
	 */
	public static <DIM_NUMERATOR extends Dimension<DIM_NUMERATOR>,
	BASE_NUMERATOR extends Unit<DIM_NUMERATOR, BASE_NUMERATOR, BASE_NUMERATOR>,
	UNIT_NUMERATOR extends Unit<DIM_NUMERATOR, BASE_NUMERATOR, UNIT_NUMERATOR>,
	DIM_DENOMINATOR extends Dimension<DIM_DENOMINATOR>,
	BASE_DENOMINATOR extends Unit<DIM_DENOMINATOR, BASE_DENOMINATOR, BASE_DENOMINATOR>,
	UNIT_DENOMINATOR extends Unit<DIM_DENOMINATOR, BASE_DENOMINATOR, UNIT_DENOMINATOR>,
	DIM_FRACTION extends Fraction<DIM_NUMERATOR, DIM_DENOMINATOR, DIM_FRACTION>,
	BASE_FRACTION extends Unit<DIM_FRACTION, BASE_FRACTION, BASE_FRACTION>,
	UNIT_FRACTION extends FractionUnit<DIM_NUMERATOR, BASE_NUMERATOR, UNIT_NUMERATOR, DIM_DENOMINATOR, BASE_DENOMINATOR, UNIT_DENOMINATOR, DIM_FRACTION, BASE_FRACTION, UNIT_FRACTION>> 
	UNIT_NUMERATOR mul(UNIT_FRACTION factor1, Unit<DIM_DENOMINATOR, BASE_DENOMINATOR, ?> factor2) {
		double valueF2 = Converter.convert(factor2, factor1.getComponentUnit2Id()).getValue();
		return UnitFactory.valueOf(factor1.getValue() * valueF2, factor1.getComponentUnit1Id());
	}
	
	/**
	 * Division of a product unit (a * b) by a unit (a).
	 * 
	 * @param product (a * b)
	 * @param divisor (a)
	 * @return the quotient of type (b)
	 * 
	 * @param <DIM_FACTOR1> dimension of product's first factor
	 * @param <BASE_FACTOR1> base unit of product's first factor's dimension
	 * @param <UNIT_FACTOR1> unit of product's first factor
	 * @param <DIM_FACTOR2> dimension of product's second factor
	 * @param <BASE_FACTOR2> base unit of product's second factor's dimension
	 * @param <UNIT_FACTOR2> unit of product's second factor
	 * @param <DIM_PRODUCT> dimension of product
	 * @param <BASE_PRODUCT> base unit of product
	 * @param <UNIT_PRODUCT> unit of product
	 */
	public static <DIM_FACTOR1 extends Dimension<DIM_FACTOR1>,
	BASE_FACTOR1 extends Unit<DIM_FACTOR1, BASE_FACTOR1, BASE_FACTOR1>,
	UNIT_FACTOR1 extends Unit<DIM_FACTOR1, BASE_FACTOR1, UNIT_FACTOR1>,
	DIM_FACTOR2 extends Dimension<DIM_FACTOR2>,
	BASE_FACTOR2 extends Unit<DIM_FACTOR2, BASE_FACTOR2, BASE_FACTOR2>,
	UNIT_FACTOR2 extends Unit<DIM_FACTOR2, BASE_FACTOR2, UNIT_FACTOR2>,
	DIM_PRODUCT extends Product<DIM_FACTOR1, DIM_FACTOR2, DIM_PRODUCT>,
	BASE_PRODUCT extends Unit<DIM_PRODUCT, BASE_PRODUCT, BASE_PRODUCT>,
	UNIT_PRODUCT extends ProductUnit<DIM_FACTOR1, BASE_FACTOR1, UNIT_FACTOR1, DIM_FACTOR2, BASE_FACTOR2, UNIT_FACTOR2, DIM_PRODUCT, BASE_PRODUCT, UNIT_PRODUCT>> 
	UNIT_FACTOR2 div1(UNIT_PRODUCT product, Unit<DIM_FACTOR1, BASE_FACTOR1, ?> divisor) {
		double valueDivisor = Converter.convert(divisor, product.getComponentUnit1Id()).getValue();
		return UnitFactory.valueOf(product.getValue() / valueDivisor, product.getComponentUnit2Id());
	}
	
	/**
	 * Division of a product unit (a * b) by a unit (b).
	 * 
	 * @param product (a * b)
	 * @param divisor (b)
	 * @return the quotient of type (a)
	 * 
	 * @param <DIM_FACTOR1> dimension of product's first factor
	 * @param <BASE_FACTOR1> base unit of product's first factor's dimension
	 * @param <UNIT_FACTOR1> unit of product's first factor
	 * @param <DIM_FACTOR2> dimension of product's second factor
	 * @param <BASE_FACTOR2> base unit of product's second factor's dimension
	 * @param <UNIT_FACTOR2> unit of product's second factor
	 * @param <DIM_PRODUCT> dimension of product
	 * @param <BASE_PRODUCT> base unit of product
	 * @param <UNIT_PRODUCT> unit of product
	 */
	public static <DIM_FACTOR1 extends Dimension<DIM_FACTOR1>,
	BASE_FACTOR1 extends Unit<DIM_FACTOR1, BASE_FACTOR1, BASE_FACTOR1>,
	UNIT_FACTOR1 extends Unit<DIM_FACTOR1, BASE_FACTOR1, UNIT_FACTOR1>,
	DIM_FACTOR2 extends Dimension<DIM_FACTOR2>,
	BASE_FACTOR2 extends Unit<DIM_FACTOR2, BASE_FACTOR2, BASE_FACTOR2>,
	UNIT_FACTOR2 extends Unit<DIM_FACTOR2, BASE_FACTOR2, UNIT_FACTOR2>,
	DIM_PRODUCT extends Product<DIM_FACTOR1, DIM_FACTOR2, DIM_PRODUCT>,
	BASE_PRODUCT extends Unit<DIM_PRODUCT, BASE_PRODUCT, BASE_PRODUCT>,
	UNIT_PRODUCT extends ProductUnit<DIM_FACTOR1, BASE_FACTOR1, UNIT_FACTOR1, DIM_FACTOR2, BASE_FACTOR2, UNIT_FACTOR2, DIM_PRODUCT, BASE_PRODUCT, UNIT_PRODUCT>>  
	UNIT_FACTOR1 div2(UNIT_PRODUCT product, Unit<DIM_FACTOR2, BASE_FACTOR2, ?> divisor) {
		double valueDivisor = Converter.convert(divisor, product.getComponentUnit2Id()).getValue();
		return UnitFactory.valueOf(product.getValue() / valueDivisor, product.getComponentUnit1Id());
	}
	
	/**
	 * Division of arbitrary units. Divide a by b and get a/b.
	 * 
	 * @param dividend dividend of division
	 * @param divisor divisor of division
	 * @param id unit id of fraction unit that consists exactly of dividend and divisor unit
	 * @return result as denoted by id
	 * 
	 * @param <DIM_DIVIDEND> dimension of dividend
	 * @param <BASE_DIVIDEND> base unit of dividend
	 * @param <DIVIDEND> unit of dividend
	 * @param <DIM_DIVISOR> dimension of divisor
	 * @param <BASE_DIVISOR> base unit of divisor
	 * @param <DIVISOR> unit of divisor
	 * @param <DIM_FRACTION> dimension of fraction
	 * @param <BASE_FRACTION> base unit of fraction
	 * @param <UNIT_FRACTION> unit of fraction
	 * @param <TARGET_UNIT_ID> target unit id
	 */
	public static <DIM_DIVIDEND extends Dimension<DIM_DIVIDEND>,
	BASE_DIVIDEND extends Unit<DIM_DIVIDEND, BASE_DIVIDEND, BASE_DIVIDEND>,
	DIVIDEND extends Unit<DIM_DIVIDEND, BASE_DIVIDEND, DIVIDEND>,
	DIM_DIVISOR extends Dimension<DIM_DIVISOR>,
	BASE_DIVISOR extends Unit<DIM_DIVISOR, BASE_DIVISOR, BASE_DIVISOR>,
	DIVISOR extends Unit<DIM_DIVISOR, BASE_DIVISOR, DIVISOR>,
	DIM_FRACTION extends Fraction<DIM_DIVIDEND, DIM_DIVISOR, DIM_FRACTION>,
	BASE_FRACTION extends Unit<DIM_FRACTION, BASE_FRACTION, BASE_FRACTION>,
	UNIT_FRACTION extends FractionUnit<DIM_DIVIDEND, BASE_DIVIDEND, DIVIDEND, DIM_DIVISOR, BASE_DIVISOR, DIVISOR, DIM_FRACTION, BASE_FRACTION, UNIT_FRACTION>,
	TARGET_UNIT_ID extends CompositeUnitId<DIM_DIVIDEND, BASE_DIVIDEND, DIVIDEND, DIM_DIVISOR, BASE_DIVISOR, DIVISOR, DIM_FRACTION, BASE_FRACTION, UNIT_FRACTION>> 
	UNIT_FRACTION div(Unit<DIM_DIVIDEND, BASE_DIVIDEND, ?> dividend, Unit<DIM_DIVISOR, BASE_DIVISOR, ?> divisor, TARGET_UNIT_ID id) {
		double valueDividend = Converter.convert(dividend, id.getComponentUnit1Id()).getValue();
		double valueDivisor = Converter.convert(divisor, id.getComponentUnit2Id()).getValue();
		return UnitFactory.valueOf(valueDividend / valueDivisor, id);
	}
	
	/**
	 * Multiplication of arbitrary units. Multiply a with b and get a*b
	 * 
	 * @param factor1 first factor of multiplication
	 * @param factor2 second factor of multiplication
	 * @param id unit id of product unit that consists exactly of factor1 and factor2 unit
	 * @return result as denoted by id
	 * 
	 * @param <DIM_FACTOR1> dimension of product's first factor
	 * @param <BASE_FACTOR1> base unit of product's first factor's dimension
	 * @param <UNIT_FACTOR1> unit of product's first factor
	 * @param <DIM_FACTOR2> dimension of product's second factor
	 * @param <BASE_FACTOR2> base unit of product's second factor's dimension
	 * @param <UNIT_FACTOR2> unit of product's second factor
	 * @param <DIM_PRODUCT> dimension of product
	 * @param <BASE_PRODUCT> base unit of product
	 * @param <UNIT_PRODUCT> unit of product
	 * @param <TARGET_UNIT_ID> target unit id
	 */
	public static <DIM_FACTOR1 extends Dimension<DIM_FACTOR1>,
	BASE_FACTOR1 extends Unit<DIM_FACTOR1, BASE_FACTOR1, BASE_FACTOR1>,
	UNIT_FACTOR1 extends Unit<DIM_FACTOR1, BASE_FACTOR1, UNIT_FACTOR1>,
	DIM_FACTOR2 extends Dimension<DIM_FACTOR2>,
	BASE_FACTOR2 extends Unit<DIM_FACTOR2, BASE_FACTOR2, BASE_FACTOR2>,
	UNIT_FACTOR2 extends Unit<DIM_FACTOR2, BASE_FACTOR2, UNIT_FACTOR2>,
	DIM_PRODUCT extends Product<DIM_FACTOR1, DIM_FACTOR2, DIM_PRODUCT>,
	BASE_PRODUCT extends Unit<DIM_PRODUCT, BASE_PRODUCT, BASE_PRODUCT>,
	UNIT_PRODUCT extends ProductUnit<DIM_FACTOR1, BASE_FACTOR1, UNIT_FACTOR1, DIM_FACTOR2, BASE_FACTOR2, UNIT_FACTOR2, DIM_PRODUCT, BASE_PRODUCT, UNIT_PRODUCT>,
	TARGET_UNIT_ID extends CompositeUnitId<DIM_FACTOR1, BASE_FACTOR1, UNIT_FACTOR1, DIM_FACTOR2, BASE_FACTOR2, UNIT_FACTOR2, DIM_PRODUCT, BASE_PRODUCT, UNIT_PRODUCT>> 
	UNIT_PRODUCT mul(Unit<DIM_FACTOR1, BASE_FACTOR1, ?> factor1, Unit<DIM_FACTOR2, BASE_FACTOR2, ?> factor2, TARGET_UNIT_ID id) {
		double valueFactor1 = Converter.convert(factor1, id.getComponentUnit1Id()).getValue();
		double valueFactor2 = Converter.convert(factor2, id.getComponentUnit2Id()).getValue();
		return UnitFactory.valueOf(valueFactor1 * valueFactor2, id);
	}
}