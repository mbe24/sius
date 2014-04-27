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
package sius.operation;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import sius.dimension.Dimension;
import sius.unit.Unit;
import sius.unit.UnitId;
import sius.unit.UnitIdentifier;
import sius.unit.length.LengthFactory;
import sius.unit.mass.MassFactory;

final class Converter {

	private static final Map<UnitId<?, ?>, Unit<?, ?>> instanceMapMutable = new HashMap<>();

	/* initialize map */
	static {
		/* mass */
		instanceMapMutable.put(UnitIdentifier.KILOGRAM, MassFactory.kg(0));
		instanceMapMutable.put(UnitIdentifier.POUND, MassFactory.lb(0));

		/* length */
		instanceMapMutable.put(UnitIdentifier.METER, LengthFactory.meter(0));
		instanceMapMutable.put(UnitIdentifier.MILE, LengthFactory.mile(0));
	}

	private static final Map<UnitId<?, ?>, Unit<?, ?>> instanceMap = Collections
			.unmodifiableMap(instanceMapMutable);

	private Converter() {
		// private constructor to prevent instantiation
	}

	public static <D extends Dimension<D>, OP extends Unit<D, OP>, CU extends Unit<D, CU>, CuId extends UnitId<D, CU>> CU convert(
			OP op, CuId cunitId) {
		@SuppressWarnings("unchecked")
		CU conversionUnit = (CU) instanceMap.get(cunitId);

		if (conversionUnit == null)
			throw new IllegalConversionException();

		return conversionUnit.convert(op);
	}

	static class IllegalConversionException extends RuntimeException {
		private static final long serialVersionUID = 1L;

		public IllegalConversionException() {
			super("Illegal conversion unit id!");
		}
	}
}