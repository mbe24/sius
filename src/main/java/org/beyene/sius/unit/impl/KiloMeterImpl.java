package org.beyene.sius.unit.impl;

import org.beyene.sius.cache.Cache;
import org.beyene.sius.cache.Caches;
import org.beyene.sius.dimension.Length;
import org.beyene.sius.unit.UnitId;
import org.beyene.sius.unit.UnitIdentifier;
import org.beyene.sius.unit.length.Constants;
import org.beyene.sius.unit.length.KiloMeter;
import org.beyene.sius.unit.length.Meter;
import org.beyene.sius.util.Preferences;

import java.util.Locale;

/**
 * Created by Fredia Huya-Kouadio on 1/20/15.
 */
public class KiloMeterImpl extends AbstractUnit<Length, Meter, KiloMeter> implements KiloMeter {

    private static final transient Cache<Length, Meter, KiloMeter> dynamicCache;
    private static final transient StaticCache<Length, Meter, KiloMeter> staticCache;

    static {
        int sizeDyn = Preferences.getInt("kilometer.cache.dynamic.size", 0);
        if(sizeDyn > 0)
            dynamicCache = Caches.newInstance(UnitIdentifier.KILOMETER, Math.abs(sizeDyn));
        else
            dynamicCache = null;

        int sizeStatic = Preferences.getInt("kilometer.cache.static.size", 1);
        if(sizeStatic > 0) {
            staticCache = new StaticCache<Length, Meter, KiloMeter>(Preferences.getInt("kilometer.cache.static.low",
                    0), sizeStatic, KiloMeterImpl.class);
        }
        else
            staticCache = null;
    }

    KiloMeterImpl(double value, Length dimension, UnitId<Length, Meter, KiloMeter> unitId,
                  Class<? extends KiloMeter> interfaceClass, Cache<Length, Meter, KiloMeter> dynamicCache,
                  StaticCache<Length, Meter, KiloMeter> staticCache){
        super(value, dimension, unitId, interfaceClass, dynamicCache, staticCache);
    }

    public KiloMeterImpl(double value){
        super(value, Length.INSTANCE, UnitIdentifier.KILOMETER, KiloMeter.class, dynamicCache, staticCache);
    }

    @Override
    public String getUnitSymbol(){
        return "km";
    }

    @Override
    public KiloMeter fromBase(Meter base) {
        return valueOf(base.getValue() / Constants.METER_PER_KILOMETER);
    }

    @Override
    public Meter toBase() {
        return FactoryLength.meter(value * Constants.METER_PER_KILOMETER);
    }

    @Override
    protected KiloMeter _this() {
        return this;
    }

    @Override
    protected KiloMeter _new_instance(double value) {
        return new KiloMeterImpl(value);
    }
}
