package org.beyene.sius.unit.composition.area;

import org.beyene.sius.dimension.Length;
import org.beyene.sius.dimension.composition.Area;
import org.beyene.sius.unit.Unit;
import org.beyene.sius.unit.composition.ProductUnit;
import org.beyene.sius.unit.length.Meter;

/**
 * Created by Fredia Huya-Kouadio on 1/20/15.
 */
public interface AreaUnit<
        FACTOR1 extends Unit<Length, Meter, FACTOR1>,
        FACTOR2 extends Unit<Length, Meter, FACTOR2>,
        T extends AreaUnit<FACTOR1, FACTOR2, T>> extends
        ProductUnit<Length, Meter, FACTOR1, Length, Meter, FACTOR2, Area, SquareMeter, T> {
}
