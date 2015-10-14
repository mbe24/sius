package org.beyene.sius.unit.impl;

import org.beyene.sius.cache.Cache;
import org.beyene.sius.cache.Caches;
import org.beyene.sius.dimension.Length;
import org.beyene.sius.dimension.composition.Area;
import org.beyene.sius.unit.UnitId;
import org.beyene.sius.unit.UnitIdentifier;
import org.beyene.sius.unit.composition.area.Constants;
import org.beyene.sius.unit.composition.area.SquareFoot;
import org.beyene.sius.unit.composition.area.SquareMeter;
import org.beyene.sius.unit.length.Foot;
import org.beyene.sius.unit.length.Meter;
import org.beyene.sius.util.Preferences;

import java.util.Locale;

/**
 * Created by Fredia Huya-Kouadio on 1/21/15.
 */
public class SquareFootImpl extends AbstractUnit<Area, SquareMeter, SquareFoot> implements SquareFoot {

    private static final transient Cache<Area, SquareMeter, SquareFoot> dynamicCache;
    private static final transient StaticCache<Area, SquareMeter, SquareFoot> staticCache;

    static {
        int sizeDyn = Preferences.getInt("squarefoot.cache.dynamic.size", 0);
        if (sizeDyn > 0)
            dynamicCache = Caches.newInstance(UnitIdentifier.SQUARE_FOOT, Math.abs(sizeDyn));
        else
            dynamicCache = null;

        int sizeStatic = Preferences.getInt("squarefoot.cache.static.size", 1);
        if (sizeStatic > 0) {
            staticCache = new StaticCache<Area, SquareMeter, SquareFoot>(Preferences.getInt("squarefoot" +
                    ".cache.static.low", 0), sizeStatic, SquareFootImpl.class);
        } else
            staticCache = null;
    }

    public SquareFootImpl(double value) {
        super(value, Area.INSTANCE, UnitIdentifier.SQUARE_FOOT, SquareFoot.class, dynamicCache, staticCache);
    }

    @Override
    public SquareFoot fromBase(SquareMeter squareMeter) {
        return valueOf(squareMeter.getValue() / Constants.SQM_PER_SQFOOT);
    }

    @Override
    public SquareMeter toBase() {
        return FactoryArea.squareMeter(value * Constants.SQM_PER_SQFOOT);
    }

    @Override
    public String getUnitSymbol(){
        return "ft" + Constants.SQUARE_SYMBOL;
    }

    @Override
    protected SquareFoot _this() {
        return this;
    }

    @Override
    protected SquareFoot _new_instance(double value) {
        return new SquareFootImpl(value);
    }

    @Override
    public UnitId<Length, Meter, Foot> getComponentUnit1Id() {
        return UnitIdentifier.FOOT;
    }

    @Override
    public UnitId<Length, Meter, Foot> getComponentUnit2Id() {
        return UnitIdentifier.FOOT;
    }
}
