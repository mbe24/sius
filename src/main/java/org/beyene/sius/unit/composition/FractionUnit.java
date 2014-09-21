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
import org.beyene.sius.dimension.composition.util.Fraction;
import org.beyene.sius.unit.Unit;

/**
 * 
 * @author mbeyene
 *
 * @param <DIM_NUMERATOR> numerator of composite dimension
 * @param <DIM_DENOMINATOR> denominator of composite dimension
 * @param <DIM_FRACTION> composite dimension of unit
 * @param <BASE_F> base unit of unit's dimension
 * @param <BASE_NUMERATOR> base unit of numerator dimension
 * @param <BASE_DENOMINATOR> base unit of denominator dimension
 * @param <UNIT_NUMERATOR> unit of numerator dimension
 * @param <UNIT_DENOMINATOR> unit of denominator dimension
 * @param <UNIT_FRACTION> self reference
 */
public interface FractionUnit<DIM_NUMERATOR extends Dimension<DIM_NUMERATOR>,
BASE_NUMERATOR extends Unit<DIM_NUMERATOR, BASE_NUMERATOR, BASE_NUMERATOR>,
UNIT_NUMERATOR extends Unit<DIM_NUMERATOR, BASE_NUMERATOR, UNIT_NUMERATOR>,
DIM_DENOMINATOR extends Dimension<DIM_DENOMINATOR>,
BASE_DENOMINATOR extends Unit<DIM_DENOMINATOR, BASE_DENOMINATOR, BASE_DENOMINATOR>,
UNIT_DENOMINATOR extends Unit<DIM_DENOMINATOR, BASE_DENOMINATOR, UNIT_DENOMINATOR>,
DIM_FRACTION extends Fraction<DIM_NUMERATOR, DIM_DENOMINATOR, DIM_FRACTION>,
BASE_F extends Unit<DIM_FRACTION, BASE_F, BASE_F>,
UNIT_FRACTION extends FractionUnit<DIM_NUMERATOR, BASE_NUMERATOR, UNIT_NUMERATOR, DIM_DENOMINATOR, BASE_DENOMINATOR, UNIT_DENOMINATOR, DIM_FRACTION, BASE_F, UNIT_FRACTION>>

extends CompositeUnit<DIM_NUMERATOR, BASE_NUMERATOR, UNIT_NUMERATOR, DIM_DENOMINATOR, BASE_DENOMINATOR, UNIT_DENOMINATOR, DIM_FRACTION, BASE_F, UNIT_FRACTION> {

}