package org.beyene.sius.unit.impl;

import org.beyene.sius.cache.Cache;
import org.beyene.sius.cache.Caches;
import org.beyene.sius.dimension.Length;
import org.beyene.sius.dimension.composition.Area;
import org.beyene.sius.unit.UnitId;
import org.beyene.sius.unit.UnitIdentifier;
import org.beyene.sius.unit.composition.area.Constants;
import org.beyene.sius.unit.composition.area.SquareKiloMeter;
import org.beyene.sius.unit.composition.area.SquareMeter;
import org.beyene.sius.unit.length.KiloMeter;
import org.beyene.sius.unit.length.Meter;
import org.beyene.sius.util.Preferences;

import java.util.Locale;

/**
 * Created by Fredia Huya-Kouadio on 1/21/15.
 */
public class SquareKiloMeterImpl extends AbstractUnit<Area, SquareMeter, SquareKiloMeter> implements SquareKiloMeter{

    private static final transient Cache<Area, SquareMeter, SquareKiloMeter> dynamicCache;
    private static final transient StaticCache<Area, SquareMeter, SquareKiloMeter> staticCache;

    static {
        int sizeDyn = Preferences.getInt("squarekilometer.cache.dynamic.size", 0);
        if(sizeDyn > 0)
            dynamicCache = Caches.newInstance(UnitIdentifier.SQUARE_KILOMETER, Math.abs(sizeDyn));
        else
            dynamicCache = null;

        int sizeStatic = Preferences.getInt("squarekilometer.cache.static.size", 1);
        if(sizeStatic > 0){
            staticCache = new StaticCache<Area, SquareMeter, SquareKiloMeter>(Preferences.getInt("squarekilometer" +
                    ".cache.static.low", 0), sizeStatic, SquareKiloMeterImpl.class);
        }
        else
            staticCache = null;
    }

    public SquareKiloMeterImpl(double value){
        super(value, Area.INSTANCE, UnitIdentifier.SQUARE_KILOMETER, SquareKiloMeter.class, dynamicCache, staticCache);
    }

    @Override
    public String getUnitSymbol(){
        return "km" + Constants.SQUARE_SYMBOL;
    }

    @Override
    public SquareKiloMeter fromBase(SquareMeter squareMeter) {
        return valueOf(squareMeter.getValue() / Constants.SQM_PER_SQKM);
    }

    @Override
    public SquareMeter toBase() {
        return FactoryArea.squareMeter(value * Constants.SQM_PER_SQKM);
    }

    @Override
    protected SquareKiloMeter _this() {
        return this;
    }

    @Override
    protected SquareKiloMeter _new_instance(double value) {
        return new SquareKiloMeterImpl(value);
    }

    @Override
    public UnitId<Length, Meter, KiloMeter> getComponentUnit1Id() {
        return UnitIdentifier.KILOMETER;
    }

    @Override
    public UnitId<Length, Meter, KiloMeter> getComponentUnit2Id() {
        return UnitIdentifier.KILOMETER;
    }
}
