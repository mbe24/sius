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
package sius.unit.composition;

import sius.dimension.Dimension;
import sius.dimension.composition.util.Composition;
import sius.unit.Unit;

public interface CompositeUnit<C1 extends Dimension<C1>,
C2 extends Dimension<C2>,
COMPOSITION extends Composition<C1, C2, COMPOSITION>,
BASE_COMPOSITION extends Unit<COMPOSITION, BASE_COMPOSITION, BASE_COMPOSITION>,
BASE_C1 extends Unit<C1, BASE_C1, BASE_C1>,
BASE_C2 extends Unit<C2, BASE_C2, BASE_C2>,
UNIT_C1 extends Unit<C1, BASE_C1, UNIT_C1>,
UNIT_C2 extends Unit<C2, BASE_C2, UNIT_C2>,
COMPOSITE_UNIT extends CompositeUnit<C1, C2, COMPOSITION, BASE_COMPOSITION, BASE_C1, BASE_C2, UNIT_C1, UNIT_C2, COMPOSITE_UNIT>>

extends Unit<COMPOSITION, BASE_COMPOSITION, COMPOSITE_UNIT> {
// @formatter:on

}
