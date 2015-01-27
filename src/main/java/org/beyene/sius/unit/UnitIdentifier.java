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

import org.beyene.sius.dimension.Dimension;
import org.beyene.sius.dimension.Length;
import org.beyene.sius.dimension.Mass;
import org.beyene.sius.dimension.Temperature;
import org.beyene.sius.dimension.Time;
import org.beyene.sius.dimension.composition.Area;
import org.beyene.sius.dimension.composition.Speed;
import org.beyene.sius.unit.composition.CompositeUnitId;
import org.beyene.sius.unit.composition.area.SquareFoot;
import org.beyene.sius.unit.composition.area.SquareInch;
import org.beyene.sius.unit.composition.area.SquareKiloMeter;
import org.beyene.sius.unit.composition.area.SquareMeter;
import org.beyene.sius.unit.composition.area.SquareMile;
import org.beyene.sius.unit.composition.area.SquareMilliMeter;
import org.beyene.sius.unit.composition.speed.FootPerSecond;
import org.beyene.sius.unit.composition.speed.MeterPerSecond;
import org.beyene.sius.unit.composition.speed.MilesPerHour;
import org.beyene.sius.unit.length.Foot;
import org.beyene.sius.unit.length.Inch;
import org.beyene.sius.unit.length.KiloMeter;
import org.beyene.sius.unit.length.Meter;
import org.beyene.sius.unit.length.Mile;
import org.beyene.sius.unit.length.MilliMeter;
import org.beyene.sius.unit.length.Yard;
import org.beyene.sius.unit.mass.KiloGram;
import org.beyene.sius.unit.mass.Pound;
import org.beyene.sius.unit.temperature.Celsius;
import org.beyene.sius.unit.temperature.Fahrenheit;
import org.beyene.sius.unit.temperature.Kelvin;
import org.beyene.sius.unit.time.Hour;
import org.beyene.sius.unit.time.Minute;
import org.beyene.sius.unit.time.Second;

/**
 * 
 * @author mbeyene
 *
 */
public final class UnitIdentifier {

	private UnitIdentifier() {
		// private constructor to prevent instantiation
	}

	/* length */

    public static final KiloMeterId KILOMETER = new KiloMeterId();

    public static final MilliMeterId MILLIMETER = new MilliMeterId();

	public static final MeterId METER = new MeterId();

	public static final MileId MILE = new MileId();

	public static final YardId YARD = new YardId();

	public static final FootId FOOT = new FootId();

	public static final InchId INCH = new InchId();

	/* mass */

	public static final KiloGramId KILOGRAM = new KiloGramId();

	public static final PoundId POUND = new PoundId();

	/* time */

	public static final SecondId SECOND = new SecondId();

	public static final MinuteId MINUTE = new MinuteId();
	
	public static final HourId HOUR = new HourId();

	/* temperature */

	public static final KelvinId KELVIN = new KelvinId();

	public static final CelsiusId CELSIUS = new CelsiusId();

	public static final FahrenheitId FAHRENHEIT = new FahrenheitId();

    /* area */
	public static final SquareMilliMeterId SQUARE_MILLIMETER = new SquareMilliMeterId();

    public static final SquareMeterId SQUARE_METER = new SquareMeterId();

    public static final SquareKiloMeterId SQUARE_KILOMETER = new SquareKiloMeterId();

	public static final SquareInchId SQUARE_INCH = new SquareInchId();

    public static final SquareFootId SQUARE_FOOT = new SquareFootId();

    public static final SquareMileId SQUARE_MILE = new SquareMileId();

	/* speed */

	public static final MeterPerSecondId METER_PER_SECOND = new MeterPerSecondId();

	public static final MilesPerHourId MILES_PER_HOUR = new MilesPerHourId();

    public static final FootPerSecondId FOOT_PER_SECOND = new FootPerSecondId();

	/* length */

    private static class KiloMeterId extends AbstractUnitId<Length, Meter, KiloMeter>{
    }

    private static class MilliMeterId extends AbstractUnitId<Length, Meter, MilliMeter>{
    }

	private static class MeterId extends AbstractUnitId<Length, Meter, Meter> {
	}

	private static class MileId extends AbstractUnitId<Length, Meter, Mile> {
	}

	private static class YardId extends AbstractUnitId<Length, Meter, Yard> {
	}

	private static class FootId extends AbstractUnitId<Length, Meter, Foot> {
	}

	private static class InchId extends AbstractUnitId<Length, Meter, Inch> {
	}

	/* mass */

	private static class KiloGramId extends
			AbstractUnitId<Mass, KiloGram, KiloGram> {
	}

	private static class PoundId extends AbstractUnitId<Mass, KiloGram, Pound> {
	}

	/* time */

	private static class SecondId extends AbstractUnitId<Time, Second, Second> {
	}

	private static class MinuteId extends AbstractUnitId<Time, Second, Minute> {
	}
	
	private static class HourId extends AbstractUnitId<Time, Second, Hour> {
	}

	/* temperature */

	private static class KelvinId extends
			AbstractUnitId<Temperature, Kelvin, Kelvin> {
	}

	private static class CelsiusId extends
			AbstractUnitId<Temperature, Kelvin, Celsius> {
	}

	private static class FahrenheitId extends
			AbstractUnitId<Temperature, Kelvin, Fahrenheit> {
	}

    /* area */
    private static class SquareMeterId extends AbstractUnitId<Area, SquareMeter, SquareMeter>
            implements CompositeUnitId<Length, Meter, Meter, Length, Meter, Meter, Area, SquareMeter, SquareMeter> {

        @Override
        public UnitId<Length, Meter, Meter> getComponentUnit1Id() {
            return UnitIdentifier.METER;
        }

        @Override
        public UnitId<Length, Meter, Meter> getComponentUnit2Id() {
            return UnitIdentifier.METER;
        }
    }

	private static class SquareMilliMeterId extends AbstractUnitId<Area, SquareMeter, SquareMilliMeter>{}

    private static class SquareKiloMeterId extends AbstractUnitId<Area, SquareMeter, SquareKiloMeter> {
    }

	private static class SquareInchId extends AbstractUnitId<Area, SquareMeter, SquareInch>{}

    private static class SquareFootId extends AbstractUnitId<Area, SquareMeter, SquareFoot> {

    }

    private static class SquareMileId extends AbstractUnitId<Area, SquareMeter, SquareMile> {

    }

	/* speed */
	private static class MeterPerSecondId extends
			AbstractUnitId<Speed, MeterPerSecond, MeterPerSecond> implements CompositeUnitId<Length, Meter, Meter, Time, Second, Second, Speed, MeterPerSecond, MeterPerSecond> {

		@Override
		public UnitId<Length, Meter, Meter> getComponentUnit1Id() {
			return UnitIdentifier.METER;
		}

		@Override
		public UnitId<Time, Second, Second> getComponentUnit2Id() {
			return UnitIdentifier.SECOND;
		}
	}

    private static class FootPerSecondId extends AbstractUnitId<Speed, MeterPerSecond, FootPerSecond>{

    }

	private static class MilesPerHourId extends
			AbstractUnitId<Speed, MeterPerSecond, MilesPerHour> {
	}

	private static abstract class AbstractUnitId<D extends Dimension<D>, BASE extends Unit<D, BASE, BASE>, U extends Unit<D, BASE, U>>
			implements UnitId<D, BASE, U> {
		private final String id = this.getClass().getName();

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((id == null) ? 0 : id.hashCode());
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (!(obj instanceof AbstractUnitId))
				return false;
			AbstractUnitId<?, ?, ?> other = (AbstractUnitId<?, ?, ?>) obj;
			if (id == null) {
				if (other.id != null)
					return false;
			} else if (!id.equals(other.id))
				return false;
			return true;
		}

		@Override
		public String toString() {
			return "UnitId [id=" + this.getClass().getSimpleName() + "]";
		}
	}
}