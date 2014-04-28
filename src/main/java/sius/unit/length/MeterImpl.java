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
import sius.operation.Operation;
import sius.unit.Unit;
import sius.unit.UnitId;
import sius.unit.UnitIdentifier;

final class MeterImpl implements Meter {

	private final double scalar;
	private final UnitId<Length, Meter, Meter> unitId = UnitIdentifier.METER;
	
	public MeterImpl(double scalar) {
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
	public UnitId<Length, Meter, Meter> getIdentifier() {
		return UnitIdentifier.METER;
	}

	@Override
	public <O extends Unit<Length, Meter, O>> Meter convert(O other) {
		Meter converted;
		if (other.getIdentifier().equals(unitId))
			converted = new MeterImpl(other.getScalar());
		else
			converted = Operation.convert(other, unitId);
		return converted;
	}

	@Override
	public Meter toBaseUnit() {
		return new MeterImpl(scalar);
	}
	
	@Override
	public Meter valueOf(double d) {
		return new MeterImpl(d);
	}

	@Override
	public String toString() {
		return "Meter [value=" + scalar + "]";
	}
}