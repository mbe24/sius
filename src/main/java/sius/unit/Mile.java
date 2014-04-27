package sius.unit;

import sius.dimension.Length;

public final class Mile implements Unit<Length, Mile> {

	private final double scalar;

	public Mile(double scalar) {
		this.scalar = scalar;
	}

	public Length getDimension() {
		return Length.INSTANCE;
	}

	public double getScalar() {
		return scalar;
	}

	public UnitIdentifier<Length> getIdentifier() {
		return UnitIdentifier.MILE;
	}

	public Mile convert(Unit<Length, ?> other) {
		Mile converted;
		if (other.getIdentifier().equals(UnitIdentifier.METER))
			converted = new Mile(other.getScalar() / 1609.344);
		else if (other.getIdentifier().equals(UnitIdentifier.MILE))
			converted = new Mile(other.getScalar());
		else
			throw new IllegalStateException("Define all necessary cases!");

		return converted;
	}

	public Mile toUnit(double scalar) {
		return new Mile(scalar);
	}

	@Override
	public String toString() {
		return "Mile [value=" + scalar + "]";
	}
}