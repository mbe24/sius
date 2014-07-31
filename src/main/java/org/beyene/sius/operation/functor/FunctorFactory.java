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
import org.beyene.sius.unit.Unit;
import org.beyene.sius.unit.UnitId;

public final class FunctorFactory {
	private FunctorFactory() {
		// private constructor to prevent instantiation
	}
	
	/**
	 * Creates adder.
	 * 
	 * @param cuid conversion unit id
	 * @return functor that performs addition
	 */
	public static <D extends Dimension<D>, B extends Unit<D, B, B>, CU extends Unit<D, B, CU>> Adder<D, B, CU> sum(UnitId<D, B, CU> cuid) {
		return new AdderImpl<D, B, CU>(cuid);
	}
	
	/**
	 * Creates mean.
	 * 
	 * @param cuid conversion unit id
	 * @return functor that computes mean
	 */
	public static <D extends Dimension<D>, B extends Unit<D, B, B>, CU extends Unit<D, B, CU>> ArithmeticMean<D, B, CU> mean(UnitId<D, B, CU> cuid) {
		return new ArithmeticMeanImpl<D, B, CU>(cuid);
	}
}