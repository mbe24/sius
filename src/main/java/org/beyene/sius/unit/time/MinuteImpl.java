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
package org.beyene.sius.unit.time;

import org.beyene.sius.dimension.Time;
import org.beyene.sius.operation.Operation;
import org.beyene.sius.unit.Unit;
import org.beyene.sius.unit.UnitId;
import org.beyene.sius.unit.UnitIdentifier;

final class MinuteImpl implements Minute {

	private final double scalar;
	private static final UnitId<Time, Second, Minute> unitId = UnitIdentifier.MINUTE;
	
	public MinuteImpl(double scalar) {
		this.scalar = scalar;
	}

	@Override
	public Time getDimension() {
		return Time.INSTANCE;
	}

	@Override
	public UnitId<Time, Second, Minute> getIdentifier() {
		return unitId;
	}

	@Override
	public <OTHER extends Unit<Time, Second, OTHER>> Minute convert(OTHER other) {
		Minute converted;
		if (other.getIdentifier().equals(unitId))
			converted = TimeFactory.minute(other.getScalar());
		else if (other.getIdentifier().equals(UnitIdentifier.SECOND))
			converted = TimeFactory.minute(other.getScalar() / Constants.SECONDS_PER_MINUTE);
		else
			converted = Operation.convert(other, unitId);
		return converted;
	}

	@Override
	public Second toBaseUnit() {
		return TimeFactory.second(scalar * Constants.SECONDS_PER_MINUTE);
	}

	@Override
	public Minute valueOf(double d) {
		return TimeFactory.minute(d);
	}

	@Override
	public double getScalar() {
		return scalar;
	}
	
	@Override
	public String toString() {
		return "Minute [value=" + scalar + "]";
	}
}