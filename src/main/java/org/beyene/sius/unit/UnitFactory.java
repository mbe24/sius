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
package org.beyene.sius.unit;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.beyene.sius.dimension.Dimension;
import org.beyene.sius.unit.impl.FactoryArea;
import org.beyene.sius.unit.impl.FactoryLength;
import org.beyene.sius.unit.impl.FactoryMass;
import org.beyene.sius.unit.impl.FactorySpeed;
import org.beyene.sius.unit.impl.FactoryTemperature;
import org.beyene.sius.unit.impl.FactoryTime;

public final class UnitFactory {

	private static final Map<UnitId<?, ?, ?>, Unit<?, ?, ?>> instanceMapMutable = new HashMap<UnitId<?, ?, ?>, Unit<?, ?, ?>>();

	/* initialize map */
	static {
		/* mass */
		instanceMapMutable.put(UnitIdentifier.KILOGRAM, FactoryMass.kg(0));
		instanceMapMutable.put(UnitIdentifier.POUND, FactoryMass.lb(0));

		/* length */
        instanceMapMutable.put(UnitIdentifier.KILOMETER, FactoryLength.kilometer(0));
        instanceMapMutable.put(UnitIdentifier.MILLIMETER, FactoryLength.millimeter(0));
		instanceMapMutable.put(UnitIdentifier.METER, FactoryLength.meter(0));
		instanceMapMutable.put(UnitIdentifier.MILE, FactoryLength.mile(0));
		instanceMapMutable.put(UnitIdentifier.YARD, FactoryLength.yard(0));
		instanceMapMutable.put(UnitIdentifier.FOOT, FactoryLength.foot(0));
		instanceMapMutable.put(UnitIdentifier.INCH, FactoryLength.inch(0));

		/* time */
		instanceMapMutable.put(UnitIdentifier.SECOND, FactoryTime.second(0));
		instanceMapMutable.put(UnitIdentifier.MINUTE, FactoryTime.minute(0));
		instanceMapMutable.put(UnitIdentifier.HOUR, FactoryTime.hour(0));

		/* temperature */
		instanceMapMutable.put(UnitIdentifier.KELVIN, FactoryTemperature.kelvin(0));
		instanceMapMutable.put(UnitIdentifier.CELSIUS, FactoryTemperature.celsius(0));
		instanceMapMutable.put(UnitIdentifier.FAHRENHEIT, FactoryTemperature.fahrenheit(0));

        /* area */
		instanceMapMutable.put(UnitIdentifier.SQUARE_MILLIMETER, FactoryArea.squareMilliMeter(0));
		instanceMapMutable.put(UnitIdentifier.SQUARE_INCH, FactoryArea.squareInch(0));
        instanceMapMutable.put(UnitIdentifier.SQUARE_METER, FactoryArea.squareMeter(0));
        instanceMapMutable.put(UnitIdentifier.SQUARE_FOOT, FactoryArea.squareFoot(0));
        instanceMapMutable.put(UnitIdentifier.SQUARE_KILOMETER, FactoryArea.squareKiloMeter(0));
        instanceMapMutable.put(UnitIdentifier.SQUARE_MILE, FactoryArea.squareMile(0));

		/* speed */
		instanceMapMutable.put(UnitIdentifier.METER_PER_SECOND, FactorySpeed.mps(0));
		instanceMapMutable.put(UnitIdentifier.MILES_PER_HOUR, FactorySpeed.mph(0));
        instanceMapMutable.put(UnitIdentifier.FOOT_PER_SECOND, FactorySpeed.ftps(0));
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