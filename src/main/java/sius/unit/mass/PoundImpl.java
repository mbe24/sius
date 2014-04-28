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
import sius.operation.Operation;
import sius.unit.Unit;
import sius.unit.UnitId;
import sius.unit.UnitIdentifier;

final class PoundImpl implements Pound {

	private final double scalar;
	private final UnitId<Mass, KiloGram, Pound> unitId = UnitIdentifier.POUND;
	
	public PoundImpl(double scalar) {
		this.scalar = scalar;
	}

	@Override
	public Mass getDimension() {
		return Mass.INSTANCE;
	}

	@Override
	public UnitId<Mass, KiloGram, Pound> getIdentifier() {
		return unitId;
	}

	@Override
	public <O extends Unit<Mass, KiloGram, O>> Pound convert(O other) {
		Pound converted;
		if (other.getIdentifier().equals(unitId))
			converted = new PoundImpl(other.getScalar());
		else if (other.getIdentifier().equals(UnitIdentifier.KILOGRAM))
			converted = new PoundImpl(other.getScalar() / Constants.KILOGRAM_PER_POUND);
		else
			converted = Operation.convert(other, unitId);
		return converted;
	}

	@Override
	public KiloGram toBaseUnit() {
		return MassFactory.kg(scalar * Constants.KILOGRAM_PER_POUND);
	}

	@Override
	public Pound valueOf(double scalar) {
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