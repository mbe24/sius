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
package org.beyene.sius.operation.functor;

import org.beyene.sius.dimension.Dimension;
import org.beyene.sius.operation.Operation;
import org.beyene.sius.unit.Unit;
import org.beyene.sius.unit.UnitFactory;
import org.beyene.sius.unit.UnitId;

final class AdderImpl<D extends Dimension<D>, B extends Unit<D, B, B>, TARGET_UNIT extends Unit<D, B, TARGET_UNIT>> extends AbstractFunctor<D, B, TARGET_UNIT, Adder<D, B, TARGET_UNIT>> implements Adder<D, B, TARGET_UNIT> {
	
	private TARGET_UNIT cachedResult;
	
	public AdderImpl(UnitId<D, B, TARGET_UNIT> targetId) {
		super(targetId, Adder.class.getSimpleName());
	}

	@Override
	public TARGET_UNIT apply() {
		if (operands.isEmpty())
			return UnitFactory.valueOf(0, targetId);

		if (cachedResult != null)
			return cachedResult;
		
		double res = 0d;
		for (Unit<D, B, ?> op : operands)
			res += Operation.convert(op, targetId).getValue();

		cachedResult = UnitFactory.valueOf(res, targetId);
		return cachedResult;
	}

	@Override
	protected Adder<D, B, TARGET_UNIT> _this() {
		return this;
	}
}