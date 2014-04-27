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
package sius.unit.length;

import sius.dimension.Length;
import sius.unit.Unit;
import sius.unit.UnitId;
import sius.unit.UnitIdentifier;

final class MetreImpl implements Metre {

	private final double scalar;

	public MetreImpl(double scalar) {
		this.scalar = scalar;
	}

	@Override
	public Length getDimension() {
		return Length.INSTANCE;
	}

	@Override
	public double getScalar() {
		return scalar;
	}

	@Override
	public UnitId<Length, Metre> getIdentifier() {
		return UnitIdentifier.METER;
	}

	@Override
	public Metre convert(Unit<Length, ?> other) {
		Metre converted;
		if (other.getIdentifier().equals(UnitIdentifier.METER))
			converted = new MetreImpl(other.getScalar());
		else if (other.getIdentifier().equals(UnitIdentifier.MILE))
			converted = new MetreImpl(other.getScalar() * 1609.344);
		else
			throw new IllegalStateException("Define all necessary cases!");

		return converted;
	}

	@Override
	public Metre toUnit(double scalar) {
		return new MetreImpl(scalar);
	}

	@Override
	public String toString() {
		return "Meter [value=" + scalar + "]";
	}
}