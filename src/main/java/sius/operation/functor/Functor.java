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
import sius.unit.Unit;
import sius.unit.UnitId;

/**
 * Functor that performs operation on arbitrary number of operands.
 * 
 * @author mbeyene
 *
 * @param <D> dimension
 * @param <F> self reference
 */
public interface Functor<D extends Dimension<D>, F extends Functor<D, F>> {

	/**
	 * Adds operand.
	 * 
	 * @param op operand to be added
	 * @return <code>this<code>
	 */
	public <B extends Unit<D, B, B>> F op(Unit<D, B, ?> op);
	
	/**
	 * Applies functor.
	 * 
	 * @param cunitId unit id of target unit
	 * @return result
	 */
	public <B extends Unit<D, B, B>, CU extends Unit<D, B, CU>, CUID extends UnitId<D, B, CU>> CU apply(CUID cunitId);
}