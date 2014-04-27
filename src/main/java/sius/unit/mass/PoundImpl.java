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
package sius.unit.mass;

import sius.dimension.Mass;
import sius.unit.Unit;
import sius.unit.UnitId;
import sius.unit.UnitIdentifier;

final class PoundImpl implements Pound {

	private final double scalar;

	public PoundImpl(double scalar) {
		this.scalar = scalar;
	}

	@Override
	public Mass getDimension() {
		return Mass.INSTANCE;
	}

	@Override
	public UnitId<Mass, Pound> getIdentifier() {
		return UnitIdentifier.POUND;
	}

	@Override
	public Pound convert(Unit<Mass, ?> other) {
		Pound converted;
		if (other.getIdentifier().equals(UnitIdentifier.KILOGRAM))
			if (other.getScalar() != 0)
				converted = new PoundImpl(other.getScalar() / 0.45359237);
			else
				converted = new PoundImpl(0);
		else if (other.getIdentifier().equals(UnitIdentifier.POUND))
			converted = new PoundImpl(other.getScalar());
		else
			throw new IllegalStateException("Define all necessary cases!");

		return converted;
	}

	@Override
	public Pound toUnit(double scalar) {
		return new PoundImpl(scalar);
	}

	@Override
	public double getScalar() {
		return scalar;
	}

	@Override
	public String toString() {
		return "Pound [value=" + scalar + "]";
	}

}