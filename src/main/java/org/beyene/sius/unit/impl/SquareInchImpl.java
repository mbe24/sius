package org.beyene.sius.unit.impl;

import org.beyene.sius.cache.Cache;
import org.beyene.sius.cache.Caches;
import org.beyene.sius.dimension.Length;
import org.beyene.sius.dimension.composition.Area;
import org.beyene.sius.unit.UnitId;
import org.beyene.sius.unit.UnitIdentifier;
import org.beyene.sius.unit.composition.area.Constants;
import org.beyene.sius.unit.composition.area.SquareInch;
import org.beyene.sius.unit.composition.area.SquareMeter;
import org.beyene.sius.unit.composition.area.SquareMile;
import org.beyene.sius.unit.length.Inch;
import org.beyene.sius.unit.length.Meter;
import org.beyene.sius.util.Preferences;

import java.util.Locale;

/**
 * Created by Fredia Huya-Kouadio on 1/26/15.
 */
public class SquareInchImpl extends AbstractUnit<Area, SquareMeter, SquareInch> implements SquareInch{

    private static final transient Cache<Area, SquareMeter, SquareInch> dynamicCache;
    private static final transient StaticCache<Area, SquareMeter, SquareInch> staticCache;

    static {
        int sizeDyn = Preferences.getInt("squareinch.cache.dynamic.size", 0);
        if (sizeDyn > 0)
            dynamicCache = Caches.newInstance(UnitIdentifier.SQUARE_INCH, Math.abs(sizeDyn));
        else
            dynamicCache = null;

        int sizeStatic = Preferences.getInt("squareinch.cache.static.size", 1);
        if (sizeStatic > 0) {
            staticCache = new StaticCache<Area, SquareMeter, SquareInch>(Preferences.getInt("squareinch" +
                    ".cache.static.low", 0), sizeStatic, SquareInchImpl.class);
        } else
            staticCache = null;
    }

    public SquareInchImpl(double value){
        super(value, Area.INSTANCE, UnitIdentifier.SQUARE_INCH, SquareInch.class, dynamicCache, staticCache);
    }

    @Override
    public String toString(){
        return String.format(Locale.US, "%2.1f in" + Constants.SQUARE_SYMBOL, value);
    }

    @Override
    public SquareInch fromBase(SquareMeter squareMeter) {
        return valueOf(squareMeter.getValue() / Constants.SQM_PER_SQINCH);
    }

    @Override
    public SquareMeter toBase() {
        return FactoryArea.squareMeter(value * Constants.SQM_PER_SQINCH);
    }

    @Override
    protected SquareInch _this() {
        return this;
    }

    @Override
    protected SquareInch _new_instance(double value) {
        return new SquareInchImpl(value);
    }

    @Override
    public UnitId<Length, Meter, Inch> getComponentUnit1Id() {
        return UnitIdentifier.INCH;
    }

    @Override
    public UnitId<Length, Meter, Inch> getComponentUnit2Id() {
        return UnitIdentifier.INCH;
    }
}
