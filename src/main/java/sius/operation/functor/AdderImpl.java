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
package sius.operation.functor;

import sius.dimension.Dimension;
import sius.operation.Operation;
import sius.unit.Unit;
import sius.unit.UnitFactory;
import sius.unit.UnitId;

final class AdderImpl<D extends Dimension<D>> extends AbstractFunctor<D, Adder<D>> implements Adder<D> {

	@Override
	public <B extends Unit<D, B, B>, CU extends Unit<D, B, CU>, CUID extends UnitId<D, B, CU>> CU apply(CUID cUnitId) {
		if (operands.isEmpty())
			return UnitFactory.valueOf(0, cUnitId);

		double res = 0d;
		for (Unit<D, ?, ?> op : operands)
			res += op.toBaseUnit().getScalar();

		/*
		 * Safe, since there is only one base unit for each dimension. To avoid
		 * cast introduce base unit as generic class parameter.
		 */
		@SuppressWarnings("unchecked")
		B b = (B) UnitFactory.valueOf(res, operands.get(0).toBaseUnit().getIdentifier());

		return Operation.convert(b, cUnitId);
	}

	@Override
	protected Adder<D> self() {
		return this;
	}
}