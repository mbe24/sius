package org.beyene.sius.unit.impl;

import org.beyene.sius.cache.Cache;
import org.beyene.sius.cache.Caches;
import org.beyene.sius.dimension.Length;
import org.beyene.sius.unit.UnitId;
import org.beyene.sius.unit.UnitIdentifier;
import org.beyene.sius.unit.length.Constants;
import org.beyene.sius.unit.length.Meter;
import org.beyene.sius.unit.length.MilliMeter;
import org.beyene.sius.util.Preferences;

import java.util.Locale;

/**
 * Created by Fredia Huya-Kouadio on 1/20/15.
 */
public class MilliMeterImpl extends AbstractUnit<Length, Meter, MilliMeter> implements MilliMeter {

    private static final transient Cache<Length, Meter, MilliMeter> dynamicCache;
    private static final transient StaticCache<Length, Meter, MilliMeter> staticCache;

    static {
        int sizeDyn = Preferences.getInt("millimeter.cache.dynamic.size", 0);
        if (sizeDyn > 0)
            dynamicCache = Caches.newInstance(UnitIdentifier.MILLIMETER, Math.abs((sizeDyn)));
        else
            dynamicCache = null;

        int sizeStatic = Preferences.getInt("millimeter.cache.static.size", 1);
        if (sizeStatic > 0) {
            staticCache = new StaticCache<Length, Meter, MilliMeter>(Preferences.getInt("millimeter.cache.static.low",
                    0), sizeStatic, MilliMeterImpl.class);
        }
        else
            staticCache = null;
    }

    public MilliMeterImpl(double value, Length dimension, UnitId<Length, Meter, MilliMeter> unitId, Class<? extends MilliMeter> interfaceClass, Cache<Length, Meter, MilliMeter> dynamicCache, StaticCache<Length, Meter, MilliMeter> staticCache) {
        super(value, dimension, unitId, interfaceClass, dynamicCache, staticCache);
    }

    public MilliMeterImpl(double value){
        super(value, Length.INSTANCE, UnitIdentifier.MILLIMETER, MilliMeter.class, dynamicCache, staticCache);
    }

    @Override
    public String toString(){
        return String.format(Locale.US, "%2.1f mm", value);
    }

    @Override
    public MilliMeter fromBase(Meter base) {
        return valueOf(base.getValue() / Constants.METER_PER_MILLIMETER);
    }

    @Override
    public Meter toBase() {
        return FactoryLength.meter(value * Constants.METER_PER_MILLIMETER);
    }

    @Override
    protected MilliMeter _this() {
        return this;
    }

    @Override
    protected MilliMeter _new_instance(double value) {
        return new MilliMeterImpl(value);
    }
}
