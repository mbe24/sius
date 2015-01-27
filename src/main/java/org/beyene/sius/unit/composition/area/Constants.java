package org.beyene.sius.unit.composition.area;

import static org.beyene.sius.unit.length.Constants.*;

/**
 * Created by Fredia Huya-Kouadio on 1/21/15.
 */
public class Constants {

    private Constants(){
        //private constructor to prevent instantiation.
    }

    public final static String SQUARE_SYMBOL = "\u00B2";

    public static final double SQM_PER_SQMM = Math.pow(METER_PER_MILLIMETER, 2);

    public static final double SQM_PER_SQKM = Math.pow(METER_PER_KILOMETER, 2);

    public static final double SQM_PER_SQINCH = Math.pow(METER_PER_INCH, 2);

    public static final double SQM_PER_SQFOOT = Math.pow(METER_PER_FOOT, 2);

    public static final double SQM_PER_SQMILE = Math.pow(METER_PER_MILE, 2);
}
