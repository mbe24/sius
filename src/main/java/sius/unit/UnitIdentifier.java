package sius.unit;

import sius.dimension.Length;

public final class UnitIdentifier<Dimension> {

	private UnitIdentifier() {
	}

	public static final UnitIdentifier<Length> METER = new UnitIdentifier<Length>();
	public static final UnitIdentifier<Length> MILE = new UnitIdentifier<Length>();
}