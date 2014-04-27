package sius.unit;

import sius.dimension.Length;

public final class Meter implements Unit<Length, Meter> {

	private final double scalar;

	public Meter(double scalar) {
		this.scalar = scalar;
	}

	public Length getDimension() {
		return Length.INSTANCE;
	}

	public double getScalar() {
		return scalar;
	}

	public UnitIdentifier<Length> getIdentifier() {
		return UnitIdentifier.METER;
	}

	public Meter convert(Unit<Length, ?> other) {
		Meter converted;
		if (other.getIdentifier().equals(UnitIdentifier.METER))
			converted = new Meter(other.getScalar()); // TODO maybe use factory to reuse immutable objects
		else if (other.getIdentifier().equals(UnitIdentifier.MILE))
			converted = new Meter(other.getScalar() * 1609.344);
		else
			throw new IllegalStateException("Define all necessary cases!");

		return converted;
	}

	public Meter toUnit(double scalar) {
		return new Meter(scalar);
	}

	@Override
	public String toString() {
		return "Meter [value=" + scalar + "]";
	}
}