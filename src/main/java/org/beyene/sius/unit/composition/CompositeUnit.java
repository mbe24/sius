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
package org.beyene.sius.unit.composition;

import org.beyene.sius.dimension.Dimension;
import org.beyene.sius.dimension.composition.util.Composition;
import org.beyene.sius.unit.Unit;
import org.beyene.sius.unit.UnitId;

/**
 * 
 * @author mbeyene
 *
 * @param <C1> 1st component of dimension
 * @param <C2> 2nd component of dimension
 * @param <COMPOSITION> composite dimension
 * @param <BASE_COMPOSITION> base unit
 * @param <BASE_C1> base unit of 1st component's dimension
 * @param <BASE_C2> base unit of 2nd component's dimension
 * @param <UNIT_C1> unit of 1st component's dimension
 * @param <UNIT_C2> unit of 2nd component's dimension
 * @param <COMPOSITE_UNIT> self reference
 */
public interface CompositeUnit<C1 extends Dimension<C1>,
BASE_C1 extends Unit<C1, BASE_C1, BASE_C1>,
UNIT_C1 extends Unit<C1, BASE_C1, UNIT_C1>,
C2 extends Dimension<C2>,
BASE_C2 extends Unit<C2, BASE_C2, BASE_C2>,
UNIT_C2 extends Unit<C2, BASE_C2, UNIT_C2>,
COMPOSITION extends Composition<C1, C2, COMPOSITION>,
BASE_COMPOSITION extends Unit<COMPOSITION, BASE_COMPOSITION, BASE_COMPOSITION>,
COMPOSITE_UNIT extends CompositeUnit<C1, BASE_C1, UNIT_C1, C2, BASE_C2, UNIT_C2, COMPOSITION, BASE_COMPOSITION, COMPOSITE_UNIT>>

extends Unit<COMPOSITION, BASE_COMPOSITION, COMPOSITE_UNIT> {
	
	public UnitId<C1, BASE_C1, UNIT_C1> getComponentUnit1Id();

	public UnitId<C2, BASE_C2, UNIT_C2> getComponentUnit2Id();
}