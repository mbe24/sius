package sius.operation;

import sius.dimension.Dimension;
import sius.unit.Unit;

public final class Operation {

	private Operation() {
	}

	/* op1 is reference unit */
	public static <D extends Dimension<D>, OP1 extends Unit<D, OP1>, OP2 extends Unit<D, OP2>> OP1 add(OP1 op1, OP2 op2) {
		return op1.toUnit(op1.getScalar() + op1.convert(op2).getScalar());
	}
}