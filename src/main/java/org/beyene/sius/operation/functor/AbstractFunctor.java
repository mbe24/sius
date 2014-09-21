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

import java.util.LinkedList;
import java.util.List;

import org.beyene.sius.dimension.Dimension;
import org.beyene.sius.unit.Unit;
import org.beyene.sius.unit.UnitId;

abstract class AbstractFunctor<D extends Dimension<D>, B extends Unit<D, B, B>, TARGET_UNIT extends Unit<D, B, TARGET_UNIT>, F extends Functor<D, B, TARGET_UNIT, F>> implements Functor<D, B, TARGET_UNIT, F>{
	
	protected final UnitId<D, B, TARGET_UNIT> targetId;
	protected final List<Unit<D, B, ?>> operands = new LinkedList<>();
	
	public AbstractFunctor(UnitId<D, B, TARGET_UNIT> targetId) {
		this.targetId = targetId;
	}

	@Override
	public F op(Unit<D, B, ?> op) {
		resetCache();
		operands.add(op);
		return _this();
	}

	@Override
	public abstract TARGET_UNIT apply();
	
	/* should return this */
	protected abstract F _this();
	
	protected abstract void resetCache();
	
	@Override
	public abstract String toString();
}