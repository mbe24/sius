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
import sius.unit.UnitIdentifier;

final class KiloGramImpl implements KiloGram {

	private final double scalar;

	public KiloGramImpl(double scalar) {
		this.scalar = scalar;
	}

	public Mass getDimension() {
		return Mass.INSTANCE;
	}

	public UnitIdentifier<Mass> getIdentifier() {
		return UnitIdentifier.KILOGRAM;
	}

	public KiloGram convert(Unit<Mass, ?> other) {
		KiloGram converted;
		if (other.getIdentifier().equals(UnitIdentifier.KILOGRAM))
			converted = new KiloGramImpl(other.getScalar());
		else if (other.getIdentifier().equals(UnitIdentifier.POUND))
			converted = new KiloGramImpl(other.getScalar() * 0.45359237);
		else
			throw new IllegalStateException("Define all necessary cases!");

		return converted;
	}

	public KiloGram toUnit(double scalar) {
		return new KiloGramImpl(scalar);
	}

	public double getScalar() {
		return scalar;
	}
	
	@Override
	public String toString() {
		return "KiloGram [value=" + scalar + "]";
	}
}