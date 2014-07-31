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
package org.beyene.sius.unit.length;

import org.beyene.sius.dimension.Length;
import org.beyene.sius.operation.Operation;
import org.beyene.sius.unit.Unit;
import org.beyene.sius.unit.UnitId;
import org.beyene.sius.unit.UnitIdentifier;

final class InchImpl implements Inch {

	private final double scalar;
	private static final UnitId<Length, Meter, Inch> unitId = UnitIdentifier.INCH;
	
	public InchImpl(double scalar) {
		this.scalar = scalar;
	}

	@Override
	public Length getDimension() {
		return Length.INSTANCE;
	}

	@Override
	public UnitId<Length, Meter, Inch> getIdentifier() {
		return unitId;
	}

	@Override
	public <OTHER extends Unit<Length, Meter, OTHER>> Inch convert(OTHER other) {
		Inch converted;
		if (other.getIdentifier().equals(unitId))
			converted = LengthFactory.inch(other.getScalar());
		else if (other.getIdentifier().equals(UnitIdentifier.METER))
			converted = LengthFactory.inch(other.getScalar() / Constants.METER_PER_INCH);
		else
			converted = Operation.convert(other, unitId);
		return converted;
	}

	@Override
	public Meter toBaseUnit() {
		return LengthFactory.meter(scalar * Constants.METER_PER_INCH);
	}

	@Override
	public Inch valueOf(double d) {
		return LengthFactory.inch(d);
	}

	@Override
	public double getScalar() {
		return scalar;
	}

	@Override
	public String toString() {
		return "Inch [value=" + scalar + "]";
	}
}