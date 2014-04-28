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

final class MileImpl implements Mile {

	private final double scalar;
	private final UnitId<Length, Meter, Mile> unitId = UnitIdentifier.MILE;
	
	public MileImpl(double scalar) {
		this.scalar = scalar;
	}

	@Override
	public Length getDimension() {
		return Length.INSTANCE;
	}

	@Override
	public UnitId<Length, Meter, Mile> getIdentifier() {
		return UnitIdentifier.MILE;
	}

	@Override
	public <O extends Unit<Length, Meter, O>> Mile convert(O other) {
		Mile converted;
		if (other.getIdentifier().equals(unitId))
			converted = new MileImpl(other.getScalar());
		else if (other.getIdentifier().equals(UnitIdentifier.METER))
			converted = new MileImpl(other.getScalar() / Constants.METER_PER_MILE);
		else
			converted = Operation.convert(other, unitId);
		return converted;
	}

	@Override
	public Meter toBaseUnit() {
		return LengthFactory.meter(scalar * Constants.METER_PER_MILE);
	}
	
	@Override
	public Mile valueOf(double d) {
		return new MileImpl(d);
	}

	@Override
	public double getScalar() {
		return scalar;
	}
	
	@Override
	public String toString() {
		return "Mile [value=" + scalar + "]";
	}
}