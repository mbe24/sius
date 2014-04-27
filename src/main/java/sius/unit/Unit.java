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
 * 
 * @author mbeyene
 *
 * @param <D>
 * @param <S>
 */
public interface Unit<D extends Dimension<D>, BASE extends Unit<D, BASE, BASE>, S extends Unit<D, BASE, S>> {

	public D getDimension();

	public UnitId<D, BASE, S> getIdentifier();

	public <O extends Unit<D, BASE, O>> S convert(O other);
	
	public BASE toBaseUnit();
	
	public S toUnit(double scalar);

	/* scalar values only..., vectors not yet supported */
	public double getScalar();

	@Override
	public String toString();
}