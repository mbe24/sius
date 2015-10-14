package org.beyene.sius.unit.impl;

import org.beyene.sius.cache.Cache;
import org.beyene.sius.cache.Caches;
import org.beyene.sius.dimension.Length;
import org.beyene.sius.dimension.Time;
import org.beyene.sius.dimension.composition.Speed;
import org.beyene.sius.unit.UnitId;
import org.beyene.sius.unit.UnitIdentifier;
import org.beyene.sius.unit.composition.speed.Constants;
import org.beyene.sius.unit.composition.speed.FootPerSecond;
import org.beyene.sius.unit.composition.speed.MeterPerSecond;
import org.beyene.sius.unit.composition.speed.MilesPerHour;
import org.beyene.sius.unit.length.Foot;
import org.beyene.sius.unit.length.Meter;
import org.beyene.sius.unit.time.Second;
import org.beyene.sius.util.Preferences;

import java.util.Locale;

/**
 * Created by Fredia Huya-Kouadio on 1/21/15.
 */
public class FootPerSecondImpl extends AbstractUnit<Speed, MeterPerSecond, FootPerSecond> implements FootPerSecond {

    private static final transient Cache<Speed, MeterPerSecond, FootPerSecond> dynamicCache;
    private static final transient StaticCache<Speed, MeterPerSecond, FootPerSecond> staticCache;

    static {
        int sizeDyn = Preferences.getInt("ftps.cache.dynamic.size", 0);
        if (sizeDyn > 0)
            dynamicCache = Caches.newInstance(UnitIdentifier.FOOT_PER_SECOND, Math.abs((sizeDyn)));
        else
            dynamicCache = null;

        int sizeStatic = Preferences.getInt("ftps.cache.static.size", 1);
        if (sizeStatic > 0)
            staticCache = new StaticCache<Speed, MeterPerSecond, FootPerSecond>(Preferences.getInt("ftps.cache" +
                    ".static.low", 0), sizeStatic, FootPerSecondImpl.class);
        else
            staticCache = null;
    }

    public FootPerSecondImpl(double value){
        super(value, Speed.INSTANCE, UnitIdentifier.FOOT_PER_SECOND, FootPerSecond.class, dynamicCache, staticCache);
    }

    @Override
    public String getUnitSymbol(){
        return "ft/s";
    }

    @Override
    public FootPerSecond fromBase(MeterPerSecond meterPerSecond) {
        return valueOf(meterPerSecond.getValue() / Constants.MPS_PER_FTPS);
    }

    @Override
    public MeterPerSecond toBase() {
        return FactorySpeed.mps(value * Constants.MPS_PER_FTPS);
    }

    @Override
    protected FootPerSecond _this() {
        return this;
    }

    @Override
    protected FootPerSecond _new_instance(double value) {
        return new FootPerSecondImpl(value);
    }

    @Override
    public UnitId<Length, Meter, Foot> getComponentUnit1Id() {
        return UnitIdentifier.FOOT;
    }

    @Override
    public UnitId<Time, Second, Second> getComponentUnit2Id() {
        return UnitIdentifier.SECOND;
    }
}
