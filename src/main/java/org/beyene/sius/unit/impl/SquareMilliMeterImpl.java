package org.beyene.sius.unit.impl;

import org.beyene.sius.cache.Cache;
import org.beyene.sius.cache.Caches;
import org.beyene.sius.dimension.Length;
import org.beyene.sius.dimension.composition.Area;
import org.beyene.sius.unit.UnitId;
import org.beyene.sius.unit.UnitIdentifier;
import org.beyene.sius.unit.composition.area.Constants;
import org.beyene.sius.unit.composition.area.SquareMeter;
import org.beyene.sius.unit.composition.area.SquareMilliMeter;
import org.beyene.sius.unit.length.Meter;
import org.beyene.sius.unit.length.MilliMeter;
import org.beyene.sius.util.Preferences;

import java.util.Locale;

/**
 * Created by Fredia Huya-Kouadio on 1/26/15.
 */
public class SquareMilliMeterImpl extends AbstractUnit<Area, SquareMeter, SquareMilliMeter> implements
        SquareMilliMeter {

    private static final transient Cache<Area, SquareMeter, SquareMilliMeter> dynamicCache;
    private static final transient StaticCache<Area, SquareMeter, SquareMilliMeter> staticCache;

    static {
        int sizeDyn = Preferences.getInt("squaremillimeter.cache.dynamic.size", 0);
        if(sizeDyn > 0)
            dynamicCache = Caches.newInstance(UnitIdentifier.SQUARE_MILLIMETER, Math.abs(sizeDyn));
        else
            dynamicCache = null;

        int sizeStatic = Preferences.getInt("squaremillimeter.cache.static.size", 1);
        if(sizeStatic > 0){
            staticCache = new StaticCache<Area, SquareMeter, SquareMilliMeter>(Preferences.getInt("squaremillimeter" +
                    ".cache.static.low", 0), sizeStatic, SquareMilliMeterImpl.class);
        }
        else
            staticCache = null;
    }

    public SquareMilliMeterImpl(double value){
        super(value, Area.INSTANCE, UnitIdentifier.SQUARE_MILLIMETER, SquareMilliMeter.class, dynamicCache,
                staticCache);
    }

    @Override
    public String getUnitSymbol(){
        return "mm" + Constants.SQUARE_SYMBOL;
    }

    @Override
    public SquareMilliMeter fromBase(SquareMeter squareMeter) {
        return valueOf(squareMeter.getValue() / Constants.SQM_PER_SQMM);
    }

    @Override
    public SquareMeter toBase() {
        return FactoryArea.squareMeter(value * Constants.SQM_PER_SQMM);
    }

    @Override
    protected SquareMilliMeter _this() {
        return this;
    }

    @Override
    protected SquareMilliMeter _new_instance(double value) {
        return new SquareMilliMeterImpl(value);
    }

    @Override
    public UnitId<Length, Meter, MilliMeter> getComponentUnit1Id() {
        return UnitIdentifier.MILLIMETER;
    }

    @Override
    public UnitId<Length, Meter, MilliMeter> getComponentUnit2Id() {
        return UnitIdentifier.MILLIMETER;
    }
}
