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
import sius.unit.length.LengthFactory;
import sius.unit.length.Meter;
import sius.unit.time.Second;
import sius.unit.time.TimeFactory;

final class MeterPerSecondImpl implements MeterPerSecond {

	private final double scalar;
	private final UnitId<Speed, MeterPerSecond, MeterPerSecond> unitId = UnitIdentifier.METER_PER_SECOND;

	public MeterPerSecondImpl(double scalar) {
		this.scalar = scalar;
	}

	@Override
	public Meter getComponentUnit1() {
		return LengthFactory.meter(0);
	}

	@Override
	public Second getComponentUnit2() {
		return TimeFactory.second(0);
	}

	@Override
	public Speed getDimension() {
		return Speed.INSTANCE;
	}

	@Override
	public UnitId<Speed, MeterPerSecond, MeterPerSecond> getIdentifier() {
		return unitId;
	}

	@Override
	public <OTHER extends Unit<Speed, MeterPerSecond, OTHER>> MeterPerSecond convert(
			OTHER other) {
		MeterPerSecond converted;
		if (other.getIdentifier().equals(unitId))
			converted = valueOf(other.getScalar());
		else
			converted = Operation.convert(other, unitId);
		return converted;
	}

	@Override
	public MeterPerSecond toBaseUnit() {
		return this;
	}

	@Override
	public MeterPerSecond valueOf(double d) {
		return new MeterPerSecondImpl(d);
	}

	@Override
	public double getScalar() {
		return scalar;
	}

	@Override
	public String toString() {
		return "MeterPerSecond [value=" + scalar + "]";
	}
}