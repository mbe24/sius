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
package org.beyene.sius.unit.impl;

import org.beyene.sius.dimension.Time;
import org.beyene.sius.operation.Operation;
import org.beyene.sius.unit.Unit;
import org.beyene.sius.unit.UnitId;
import org.beyene.sius.unit.UnitIdentifier;
import org.beyene.sius.unit.time.Second;

final class SecondImpl implements Second {

	private final double scalar;
	private static final UnitId<Time, Second, Second> unitId = UnitIdentifier.SECOND;
	
	public SecondImpl(double scalar) {
		this.scalar = scalar;
	}

	@Override
	public Time getDimension() {
		return Time.INSTANCE;
	}

	@Override
	public UnitId<Time, Second, Second> getIdentifier() {
		return unitId;
	}

	@Override
	public <OTHER extends Unit<Time, Second, OTHER>> Second convert(OTHER other) {
		Second converted;
		if (other.getIdentifier().equals(unitId))
			converted = FactoryTime.second(other.getValue());
		else
			converted = Operation.convert(other, unitId);
		return converted;
	}

	@Override
	public Second toBaseUnit() {
		return FactoryTime.second(scalar);
	}

	@Override
	public Second valueOf(double d) {
		return FactoryTime.second(d);
	}

	@Override
	public double getValue() {
		return scalar;
	}

	@Override
	public String toString() {
		return "Second [value=" + scalar + "]";
	}
}