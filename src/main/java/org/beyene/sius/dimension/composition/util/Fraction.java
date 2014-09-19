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
package org.beyene.sius.dimension.composition.util;

import org.beyene.sius.dimension.Dimension;

//public interface Fraction<NUMERATOR extends Dimension<NUMERATOR>, DENOMINATOR extends Dimension<DENOMINATOR>, FRACTION extends Fraction<NUMERATOR, DENOMINATOR, FRACTION>>
//		extends Dimension<FRACTION> {

public interface Fraction<NUMERATOR extends Dimension<NUMERATOR>, DENOMINATOR extends Dimension<DENOMINATOR>, F extends Fraction<NUMERATOR, DENOMINATOR, F>>
		extends Composition<NUMERATOR, DENOMINATOR, F> {

	public NUMERATOR getNumerator();

	public DENOMINATOR getDenominator();
}