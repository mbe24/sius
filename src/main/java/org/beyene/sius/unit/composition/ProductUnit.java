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
import org.beyene.sius.dimension.composition.util.Product;
import org.beyene.sius.unit.Unit;

/**
 * 
 * @author mbeyene
 *
 * @param <FACTOR1> factor 1 composite dimension
 * @param <FACTOR2> factor 2 of composite dimension
 * @param <P> composite product dimension of unit
 * @param <BASE_P> base unit of unit's dimension
 * @param <BASE_FACTOR1> base unit of numerator dimension
 * @param <BASE_FACTOR2> base unit of denominator dimension
 * @param <UNIT_FACTOR1> unit of numerator dimension
 * @param <UNIT_FACTOR2> unit of denominator dimension
 * @param <UNIT_PRODUCT> self reference
 */
public interface ProductUnit<FACTOR1 extends Dimension<FACTOR1>,
FACTOR2 extends Dimension<FACTOR2>,
P extends Product<FACTOR1, FACTOR2, P>,
BASE_P extends Unit<P, BASE_P, BASE_P>,
BASE_FACTOR1 extends Unit<FACTOR1, BASE_FACTOR1, BASE_FACTOR1>,
BASE_FACTOR2 extends Unit<FACTOR2, BASE_FACTOR2, BASE_FACTOR2>,
UNIT_FACTOR1 extends Unit<FACTOR1, BASE_FACTOR1, UNIT_FACTOR1>,
UNIT_FACTOR2 extends Unit<FACTOR2, BASE_FACTOR2, UNIT_FACTOR2>,
UNIT_PRODUCT extends ProductUnit<FACTOR1, FACTOR2, P, BASE_P, BASE_FACTOR1, BASE_FACTOR2, UNIT_FACTOR1, UNIT_FACTOR2, UNIT_PRODUCT>>

extends CompositeUnit<FACTOR1, FACTOR2, P, BASE_P, BASE_FACTOR1, BASE_FACTOR2, UNIT_FACTOR1, UNIT_FACTOR2, UNIT_PRODUCT> {

}