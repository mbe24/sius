package sius.unit.length;

import sius.dimension.Length;
import sius.operation.Operation;
import sius.unit.Unit;
import sius.unit.UnitId;
import sius.unit.UnitIdentifier;

final class YardImpl implements Yard {

	private final double scalar;
	
	public YardImpl(double scalar) {
		this.scalar = scalar;
	}

	@Override
	public Length getDimension() {
		return Length.INSTANCE;
	}

	@Override
	public UnitId<Length, Meter, Yard> getIdentifier() {
		return UnitIdentifier.YARD;
	}

	@Override
	public <O extends Unit<Length, Meter, O>> Yard convert(O other) {
		Yard converted;
		if (other.getIdentifier().equals(UnitIdentifier.YARD))
			converted = new YardImpl(other.getScalar());
		else if (other.getIdentifier().equals(UnitIdentifier.METER))
			converted = new YardImpl(other.getScalar() / Constants.METER_PER_YARD);
		else
			converted = Operation.convert(other, UnitIdentifier.YARD);
		return converted;
	}

	@Override
	public Meter toBaseUnit() {
		return LengthFactory.meter(scalar * Constants.METER_PER_YARD);
	}

	@Override
	public Yard toUnit(double scalar) {
		return new YardImpl(scalar);
	}

	@Override
	public double getScalar() {
		return scalar;
	}
	
	@Override
	public String toString() {
		return "Yard [value=" + scalar + "]";
	}
}