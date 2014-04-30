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
	private static final UnitId<Length, Meter, Meter> unitId = UnitIdentifier.METER;

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
			converted = LengthFactory.meter(other.getScalar());
		else
			converted = Operation.convert(other, unitId);
		return converted;
	}

	@Override
	public Meter toBaseUnit() {
		return LengthFactory.meter(scalar);
	}

	@Override
	public Meter valueOf(double d) {
		if ((d == Math.floor(d)) && !Double.isInfinite(d)) {
		    int i = (int) d;
		    if (i >= MeterCache.low && i <= MeterCache.high)
		    	return MeterCache.cache[i + (-MeterCache.low)];
		}
		return new MeterImpl(d);
	}

	@Override
	public String toString() {
		return "Meter [value=" + scalar + "]";
	}

	/* static cache inspired by java.lang.Integer */
	private static final class MeterCache {
		static final int low = -128;
		static final int high = 127;
		static final Meter[] cache;

		static {
			cache = new Meter[(high - low) + 1];
			int j = low;
			for (int k = 0; k < cache.length; k++)
				cache[k] = new MeterImpl(j++);
		}
		private MeterCache() {
			// private constructor to prevent instantiation
		}
	}
}