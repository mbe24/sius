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

import java.util.LinkedList;
import java.util.List;

import sius.dimension.Dimension;
import sius.unit.Unit;
import sius.unit.UnitId;

abstract class AbstractFunctor<D extends Dimension<D>, F extends Functor<D, F>> implements Functor<D, F>{

	protected final List<Unit<D, ?, ?>> operands = new LinkedList<>();

	@Override
	public <B extends Unit<D, B, B>> F op(Unit<D, B, ?> op) {
		operands.add(op);
		return self();
	}

	@Override
	public abstract <B extends Unit<D, B, B>, CU extends Unit<D, B, CU>, CUID extends UnitId<D, B, CU>> CU apply(CUID cUnitId);
	
	/* should return this */
	protected abstract F self();
}