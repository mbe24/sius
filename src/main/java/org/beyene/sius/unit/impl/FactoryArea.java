package org.beyene.sius.unit.impl;

import org.beyene.sius.unit.composition.area.SquareFoot;
import org.beyene.sius.unit.composition.area.SquareInch;
import org.beyene.sius.unit.composition.area.SquareKiloMeter;
import org.beyene.sius.unit.composition.area.SquareMeter;
import org.beyene.sius.unit.composition.area.SquareMile;
import org.beyene.sius.unit.composition.area.SquareMilliMeter;

/**
 * Created by Fredia Huya-Kouadio on 1/20/15.
 */
public final class FactoryArea {

    private FactoryArea(){
        //private constructor to prevent instantiation
    }

    private static SquareMilliMeter squareMilliMeter = new SquareMilliMeterImpl(0).valueOf(0);
    public static SquareMilliMeter squareMilliMeter(double value){
        return squareMilliMeter.valueOf(value);
    }

    private static SquareMeter squareMeter = new SquareMeterImpl(0).valueOf(0);
    public static SquareMeter squareMeter(double value) {
        return squareMeter.valueOf(value);
    }

    private static SquareKiloMeter squareKiloMeter = new SquareKiloMeterImpl(0).valueOf(0);
    public static SquareKiloMeter squareKiloMeter(double value){
        return squareKiloMeter.valueOf(value);
    }

    private static SquareInch squareInch = new SquareInchImpl(0).valueOf(0);
    public static SquareInch squareInch(double value){
        return squareInch.valueOf(value);
    }

    private static SquareFoot squareFoot = new SquareFootImpl(0).valueOf(0);
    public static SquareFoot squareFoot(double value){
        return squareFoot.valueOf(value);
    }

    private static SquareMile squareMile = new SquareMileImpl(0).valueOf(0);
    public static SquareMile squareMile(double value){
        return squareMile.valueOf(value);
    }
}
