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
import sius.unit.Unit;
import sius.unit.UnitId;

public final class Operation {

	private Operation() {
		// private constructor to prevent instantiation
	}

	public static <D extends Dimension<D>, OP extends Unit<D, OP>, CU extends Unit<D, CU>, CuId extends UnitId<D, CU>> CU convert(
			OP op, CuId cunitId) {
		return Converter.convert(op, cunitId);
	}

	/* op1 is reference unit */
	public static <D extends Dimension<D>, OP1 extends Unit<D, OP1>, OP2 extends Unit<D, OP2>> OP1 add(
			OP1 op1, OP2 op2) {
		return op1.toUnit(op1.getScalar() + op1.convert(op2).getScalar());
	}

	/* op1 - op2 */
	public static <D extends Dimension<D>, OP1 extends Unit<D, OP1>, OP2 extends Unit<D, OP2>> OP1 sub(
			OP1 op1, OP2 op2) {
		return op1.toUnit(op1.getScalar() - op1.convert(op2).getScalar());
	}
}