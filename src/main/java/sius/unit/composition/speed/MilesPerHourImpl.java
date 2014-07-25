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
package sius.unit.composition.speed;

import sius.dimension.composition.Speed;
import sius.operation.Operation;
import sius.unit.Unit;
import sius.unit.UnitId;
import sius.unit.UnitIdentifier;

public class MilesPerHourImpl implements MilesPerHour {

	private final double scalar;
	private final UnitId<Speed, MeterPerSecond, MilesPerHour> unitId = UnitIdentifier.MILES_PER_HOUR;

	public MilesPerHourImpl(double scalar) {
		this.scalar = scalar;
	}

	@Override
	public Speed getDimension() {
		return Speed.INSTANCE;
	}

	@Override
	public UnitId<Speed, MeterPerSecond, MilesPerHour> getIdentifier() {
		return unitId;
	}

	@Override
	public <OTHER extends Unit<Speed, MeterPerSecond, OTHER>> MilesPerHour convert(
			OTHER other) {
		MilesPerHour converted;
		if (other.getIdentifier().equals(unitId))
			converted = valueOf(other.getScalar());
		else if (other.getIdentifier().equals(UnitIdentifier.METER_PER_SECOND))
			converted = valueOf(other.getScalar() * Constants.MPS_PER_MPH);
		else
			converted = Operation.convert(other, unitId);
		return converted;
	}

	@Override
	public MeterPerSecond toBaseUnit() {
		return SpeedFactory.mps(scalar / Constants.MPS_PER_MPH);
	}

	@Override
	public MilesPerHour valueOf(double d) {
		return new MilesPerHourImpl(d);
	}

	@Override
	public double getScalar() {
		return scalar;
	}

	@Override
	public String toString() {
		return "MilesPerHour [value=" + scalar + "]";
	}
}