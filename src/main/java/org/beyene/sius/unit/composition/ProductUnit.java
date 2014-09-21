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
 * @param <DIM_FACTOR1> factor 1 composite dimension
 * @param <DIM_FACTOR2> factor 2 of composite dimension
 * @param <DIM_PRODUCT> composite product dimension of unit
 * @param <BASE_P> base unit of unit's dimension
 * @param <BASE_FACTOR1> base unit of numerator dimension
 * @param <BASE_FACTOR2> base unit of denominator dimension
 * @param <UNIT_FACTOR1> unit of numerator dimension
 * @param <UNIT_FACTOR2> unit of denominator dimension
 * @param <UNIT_PRODUCT> self reference
 */
public interface ProductUnit<DIM_FACTOR1 extends Dimension<DIM_FACTOR1>,
BASE_FACTOR1 extends Unit<DIM_FACTOR1, BASE_FACTOR1, BASE_FACTOR1>,
UNIT_FACTOR1 extends Unit<DIM_FACTOR1, BASE_FACTOR1, UNIT_FACTOR1>,
DIM_FACTOR2 extends Dimension<DIM_FACTOR2>,
BASE_FACTOR2 extends Unit<DIM_FACTOR2, BASE_FACTOR2, BASE_FACTOR2>,
UNIT_FACTOR2 extends Unit<DIM_FACTOR2, BASE_FACTOR2, UNIT_FACTOR2>,
DIM_PRODUCT extends Product<DIM_FACTOR1, DIM_FACTOR2, DIM_PRODUCT>,
BASE_P extends Unit<DIM_PRODUCT, BASE_P, BASE_P>,
UNIT_PRODUCT extends ProductUnit<DIM_FACTOR1, BASE_FACTOR1, UNIT_FACTOR1, DIM_FACTOR2, BASE_FACTOR2, UNIT_FACTOR2, DIM_PRODUCT, BASE_P, UNIT_PRODUCT>>

extends CompositeUnit<DIM_FACTOR1, BASE_FACTOR1, UNIT_FACTOR1, DIM_FACTOR2, BASE_FACTOR2, UNIT_FACTOR2, DIM_PRODUCT, BASE_P, UNIT_PRODUCT> {

}