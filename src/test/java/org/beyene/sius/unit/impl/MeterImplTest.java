package org.beyene.sius.unit.impl;


import org.beyene.sius.unit.impl.FactoryLength;
import org.beyene.sius.unit.impl.MeterImpl;
import org.beyene.sius.unit.length.Constants;
import org.beyene.sius.unit.length.Inch;
import org.beyene.sius.unit.length.Meter;
import org.beyene.sius.util.Preferences;
import org.junit.Assert;
import org.junit.Test;

public class MeterImplTest {

	@Test
	public void testToBaseUnit() throws Exception {
		Meter first = FactoryLength.meter(1);
		Meter second = first.toBaseUnit();

		Assert.assertEquals(first, second);
		Assert.assertTrue(first == second);
	}

	@Test
	public void testValueOf() throws Exception {
		int low = Preferences.loadInt("meter.cache.static.low", 0);
		int high = low + Math.abs((Preferences.loadInt("meter.cache.static.size", 128) - 1));
		
		int i = (low + high) / 2;
		Meter reference = FactoryLength.meter(0);
		
		Meter m1 = reference.valueOf(i);
		Meter m2 = reference.valueOf(i);
		
		Assert.assertEquals(m1, m2);
		Assert.assertTrue(m1 == m2);
		
		Meter m3 = new MeterImpl(i);
		Meter m4 = new MeterImpl(i);
		
		Assert.assertEquals(m3, m4);
		Assert.assertTrue(m3 != m4);
		
		Meter m5 = reference.valueOf(7.77);
		Meter m6 = reference.valueOf(7.77);
		
		Assert.assertEquals(m5, m6);
		Assert.assertTrue(m5 == m6);
	}

	@Test
	public void testConvert() throws Exception {
		int low = Preferences.loadInt("meter.cache.static.low", 0);
		int high = low + Math.abs((Preferences.loadInt("meter.cache.static.size", 128) - 1));
		int i = (low + high) / 2;
		
		Meter reference = FactoryLength.meter(0);
		
		Inch in = FactoryLength.inch(100);
		Meter other = FactoryLength.meter(i);
		
		Meter convertedMeter = reference.convert(other);
		Assert.assertEquals(convertedMeter, other);
		Assert.assertTrue(convertedMeter == other);
		
		Meter convertedInch = reference.convert(in);
		Meter coresponding = FactoryLength.meter(100 * Constants.METER_PER_INCH);
		Assert.assertEquals(convertedInch, coresponding);
		Assert.assertTrue(convertedInch == coresponding);
	}
}