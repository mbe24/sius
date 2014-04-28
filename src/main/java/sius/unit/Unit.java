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
package sius.unit;

import sius.dimension.Dimension;

/**
 * Physical unit.
 * 
 * @author mbeyene
 *
 * @param <D> dimension of unit
 * @param <BASE> base unit of unit's dimension
 * @param <SELF> self reference
 */
public interface Unit<D extends Dimension<D>, BASE extends Unit<D, BASE, BASE>, SELF extends Unit<D, BASE, SELF>> {

	public D getDimension();

	public UnitId<D, BASE, SELF> getIdentifier();

	public <OTHER extends Unit<D, BASE, OTHER>> SELF convert(OTHER other);
	
	public BASE toBaseUnit();
	
	public SELF valueOf(double d);

	/* scalar values only..., vectors not yet supported */
	public double getScalar();

	@Override
	public int hashCode();
	
	@Override
	public boolean equals(Object obj);
	
	@Override
	public String toString();
}