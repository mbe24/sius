package sius.unit;

import sius.dimension.Dimension;

public interface Unit<D extends Dimension<D>, S extends Unit<D, S>> {

	public D getDimension();

	public UnitIdentifier<D> getIdentifier();

	public S convert(Unit<D, ?> other);

	public S toUnit(double scalar);

	/* scalar values only... */
	public double getScalar();

	@Override
	public String toString();
}