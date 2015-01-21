package org.beyene.sius.unit.impl;

import org.beyene.sius.cache.Cache;
import org.beyene.sius.cache.Caches;
import org.beyene.sius.dimension.Length;
import org.beyene.sius.dimension.composition.Area;
import org.beyene.sius.unit.UnitId;
import org.beyene.sius.unit.UnitIdentifier;
import org.beyene.sius.unit.composition.area.Constants;
import org.beyene.sius.unit.composition.area.SquareMeter;
import org.beyene.sius.unit.composition.area.SquareMile;
import org.beyene.sius.unit.length.Meter;
import org.beyene.sius.unit.length.Mile;
import org.beyene.sius.util.Preferences;

/**
 * Created by Fredia Huya-Kouadio on 1/21/15.
 */
public class SquareMileImpl extends AbstractUnit<Area, SquareMeter, SquareMile> implements SquareMile {

    private static final transient Cache<Area, SquareMeter, SquareMile> dynamicCache;
    private static final transient StaticCache<Area, SquareMeter, SquareMile> staticCache;

    static {
        int sizeDyn = Preferences.getInt("squaremile.cache.dynamic.size", 0);
        if (sizeDyn > 0)
            dynamicCache = Caches.newInstance(UnitIdentifier.SQUARE_MILE, Math.abs(sizeDyn));
        else
            dynamicCache = null;

        int sizeStatic = Preferences.getInt("squaremile.cache.static.size", 1);
        if (sizeStatic > 0) {
            staticCache = new StaticCache<Area, SquareMeter, SquareMile>(Preferences.getInt("squaremile" +
                    ".cache.static.low", 0), sizeStatic, SquareMileImpl.class);
        } else
            staticCache = null;
    }

    public SquareMileImpl(double value) {
        super(value, Area.INSTANCE, UnitIdentifier.SQUARE_MILE, SquareMile.class, dynamicCache, staticCache);
    }

    @Override
    public SquareMile fromBase(SquareMeter squareMeter) {
        return valueOf(squareMeter.getValue() / Constants.SQM_PER_SQMILE);
    }

    @Override
    public SquareMeter toBase() {
        return FactoryArea.squareMeter(value * Constants.SQM_PER_SQMILE);
    }

    @Override
    protected SquareMile _this() {
        return this;
    }

    @Override
    protected SquareMile _new_instance(double value) {
        return new SquareMileImpl(value);
    }

    @Override
    public UnitId<Length, Meter, Mile> getComponentUnit1Id() {
        return UnitIdentifier.MILE;
    }

    @Override
    public UnitId<Length, Meter, Mile> getComponentUnit2Id() {
        return UnitIdentifier.MILE;
    }
}
