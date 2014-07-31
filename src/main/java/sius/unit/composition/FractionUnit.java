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
import sius.dimension.composition.util.Fraction;
import sius.unit.Unit;

/**
 * 
 * @author mbeyene
 *
 * @param <NUMERATOR> numerator of composite dimension
 * @param <DENOMINATOR> denominator of composite dimension
 * @param <F> composite dimension of unit
 * @param <BASE_F> base unit of unit's dimension
 * @param <BASE_NUMERATOR> base unit of numerator dimension
 * @param <BASE_DENOMINATOR> base unit of denominator dimension
 * @param <UNIT_NUMERATOR> unit of numerator dimension
 * @param <UNIT_DENOMINATOR> unit of denominator dimension
 * @param <UNIT_FRACTION> self reference
 */
public interface FractionUnit<NUMERATOR extends Dimension<NUMERATOR>,
DENOMINATOR extends Dimension<DENOMINATOR>,
F extends Fraction<NUMERATOR, DENOMINATOR, F>,
BASE_F extends Unit<F, BASE_F, BASE_F>,
BASE_NUMERATOR extends Unit<NUMERATOR, BASE_NUMERATOR, BASE_NUMERATOR>,
BASE_DENOMINATOR extends Unit<DENOMINATOR, BASE_DENOMINATOR, BASE_DENOMINATOR>,
UNIT_NUMERATOR extends Unit<NUMERATOR, BASE_NUMERATOR, UNIT_NUMERATOR>,
UNIT_DENOMINATOR extends Unit<DENOMINATOR, BASE_DENOMINATOR, UNIT_DENOMINATOR>,
UNIT_FRACTION extends FractionUnit<NUMERATOR, DENOMINATOR, F, BASE_F, BASE_NUMERATOR, BASE_DENOMINATOR, UNIT_NUMERATOR, UNIT_DENOMINATOR, UNIT_FRACTION>>

extends CompositeUnit<NUMERATOR, DENOMINATOR, F, BASE_F, BASE_NUMERATOR, BASE_DENOMINATOR, UNIT_NUMERATOR, UNIT_DENOMINATOR, UNIT_FRACTION> {

}