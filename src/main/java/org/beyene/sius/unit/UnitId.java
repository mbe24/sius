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
package org.beyene.sius.unit;

import org.beyene.sius.dimension.Dimension;

/**
 * Unit Identifier.
 * 
 * @author mbeyene
 *
 * @param <D> dimension of unit.
 * @param <BASE> base unit of unit's dimension.
 * @param <U> unit to be identified.
 */
public interface UnitId<D extends Dimension<D>, BASE extends Unit<D, BASE, BASE>, U extends Unit<D, BASE, U>> {
	
}