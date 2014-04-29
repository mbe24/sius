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
package sius.unit;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import sius.dimension.Dimension;
import sius.unit.length.LengthFactory;
import sius.unit.mass.MassFactory;
import sius.unit.temperature.TemperatureFactory;
import sius.unit.time.TimeFactory;

public final class UnitFactory {

	private static final Map<UnitId<?, ?, ?>, Unit<?, ?, ?>> instanceMapMutable = new HashMap<>();

	/* initialize map */
	static {
		/* mass */
		instanceMapMutable.put(UnitIdentifier.KILOGRAM, MassFactory.kg(0));
		instanceMapMutable.put(UnitIdentifier.POUND, MassFactory.lb(0));

		/* length */
		instanceMapMutable.put(UnitIdentifier.METER, LengthFactory.meter(0));
		instanceMapMutable.put(UnitIdentifier.MILE, LengthFactory.mile(0));
		instanceMapMutable.put(UnitIdentifier.YARD, LengthFactory.yard(0));
		instanceMapMutable.put(UnitIdentifier.FOOT, LengthFactory.foot(0));
		instanceMapMutable.put(UnitIdentifier.INCH, LengthFactory.inch(0));

		/* time */
		instanceMapMutable.put(UnitIdentifier.SECOND, TimeFactory.second(0));
		instanceMapMutable.put(UnitIdentifier.MINUTE, TimeFactory.minute(0));

		/* temperature */
		instanceMapMutable.put(UnitIdentifier.KELVIN, TemperatureFactory.kelvin(0));
		instanceMapMutable.put(UnitIdentifier.CELSIUS, TemperatureFactory.celsius(0));
		instanceMapMutable.put(UnitIdentifier.FAHRENHEIT, TemperatureFactory.fahrenheit(0));
	}
	private static final Map<UnitId<?, ?, ?>, Unit<?, ?, ?>> instanceMap = Collections.unmodifiableMap(instanceMapMutable);

	private UnitFactory() {
		// private constructor to prevent instantiation
	}

	public static <D extends Dimension<D>, B extends Unit<D, B, B>, U extends Unit<D, B, U>, UID extends UnitId<D, B, U>> U valueOf(double d, UID id) {
		@SuppressWarnings("unchecked")
		U unit = (U) instanceMap.get(id);
		
		if (unit == null)
			throw new UnsupportedUnitException(id);
		
		return unit.valueOf(d);
	}
	
	public static class UnsupportedUnitException extends RuntimeException {
		private static final long serialVersionUID = 1L;

		public UnsupportedUnitException(UnitId<?, ?, ?> uid) {
			super(String.format("Unit identified by %s is not supported!", uid.getClass().getSimpleName()));
		}
	}
}