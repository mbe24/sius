package org.beyene.sius.unit.impl;

import org.beyene.sius.cache.Cache;
import org.beyene.sius.cache.Caches;
import org.beyene.sius.dimension.Length;
import org.beyene.sius.dimension.composition.Area;
import org.beyene.sius.dimension.composition.Speed;
import org.beyene.sius.unit.UnitId;
import org.beyene.sius.unit.UnitIdentifier;
import org.beyene.sius.unit.composition.area.Constants;
import org.beyene.sius.unit.composition.area.SquareMeter;
import org.beyene.sius.unit.composition.speed.MeterPerSecond;
import org.beyene.sius.unit.length.Meter;
import org.beyene.sius.util.Preferences;

import java.util.Locale;

/**
 * Created by Fredia Huya-Kouadio on 1/20/15.
 */
public class SquareMeterImpl extends AbstractUnit<Area, SquareMeter, SquareMeter> implements SquareMeter {

    private static final transient Cache<Area, SquareMeter, SquareMeter> dynamicCache;
    private static final transient StaticCache<Area, SquareMeter, SquareMeter> staticCache;

    static {
        int sizeDyn = Preferences.getInt("squaremeter.cache.dynamic.size", 0);
        if(sizeDyn > 0)
            dynamicCache = Caches.newInstance(UnitIdentifier.SQUARE_METER, Math.abs(sizeDyn));
        else
            dynamicCache = null;

        int sizeStatic = Preferences.getInt("squaremeter.cache.static.size", 1);
        if(sizeStatic > 0){
            staticCache = new StaticCache<Area, SquareMeter, SquareMeter>(Preferences.getInt("squaremeter.cache" +
                    ".static.low", 0), sizeStatic, SquareMeterImpl.class);
        }
        else
            staticCache = null;
    }

    public SquareMeterImpl(double value, Area dimension, UnitId<Area, SquareMeter, SquareMeter> unitId, Class<? extends SquareMeter> interfaceClass, Cache<Area, SquareMeter, SquareMeter> dynamicCache, StaticCache<Area, SquareMeter, SquareMeter> staticCache) {
        super(value, dimension, unitId, interfaceClass, dynamicCache, staticCache);
    }

    public SquareMeterImpl(double value){
        super(value, Area.INSTANCE, UnitIdentifier.SQUARE_METER, SquareMeter.class, dynamicCache, staticCache);
    }

    @Override
    public String toString(){
        return String.format(Locale.US, "%2.1f m" + Constants.SQUARE_SYMBOL, value);
    }

    @Override
    public SquareMeter fromBase(SquareMeter base) {
        return valueOf(base.getValue());
    }

    @Override
    public SquareMeter toBase() {
        return this;
    }

    @Override
    protected SquareMeter _this() {
        return this;
    }

    @Override
    protected SquareMeter _new_instance(double value) {
        return new SquareMeterImpl(value);
    }

    @Override
    public UnitId<Length, Meter, Meter> getComponentUnit1Id() {
        return UnitIdentifier.METER;
    }

    @Override
    public UnitId<Length, Meter, Meter> getComponentUnit2Id() {
        return UnitIdentifier.METER;
    }
}
