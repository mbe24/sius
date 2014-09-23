/*
 * Copyright 2014 Mikael Beyene
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * 
 */
package org.beyene.sius.unit.impl;


import org.beyene.sius.cache.Cache;
import org.beyene.sius.cache.Caches;
import org.beyene.sius.dimension.Length;
import org.beyene.sius.unit.UnitId;
import org.beyene.sius.unit.UnitIdentifier;
import org.beyene.sius.unit.length.Inch;
import org.beyene.sius.unit.length.Meter;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class AbstractUnitTest {

	private Length dimension = Length.INSTANCE;
	private UnitId<Length, Meter, Meter> unitId = UnitIdentifier.METER;
	private Class<? extends Meter> interfaceClass = Meter.class;
	private Cache<Length, Meter, Meter> dynamicCache;
	private StaticCache<Length, Meter, Meter> staticCache;
	private double value = 5;
	
	private Meter m ;
	
	@Before
	public void setUp() {
		dynamicCache = Caches.newInstance(unitId, 10);
		staticCache = new StaticCache<Length, Meter, Meter>(0, 10, MeterImpl.class);
		m = new MeterImpl(value, dimension, unitId, interfaceClass, dynamicCache, staticCache);
	}
	
	@Test
	public void testHashCode() throws Exception {
		Meter m2 = new MeterImpl(value, dimension, unitId, interfaceClass, dynamicCache, staticCache);
		Assert.assertEquals(m.hashCode(), m2.hashCode());
		
		m2 = new MeterImpl(value, dimension, unitId, null, dynamicCache, staticCache);
		Assert.assertFalse(m.hashCode() == m2.hashCode());
		
		Meter m3 = new MeterImpl(value + 1, dimension, unitId, interfaceClass, dynamicCache, staticCache);
		Assert.assertFalse(m.hashCode() == m3.hashCode());
	}

	@Test
	public void testGetDimension() throws Exception {
		Assert.assertTrue(m.getDimension() == dimension);
	}

	@Test
	public void testGetIdentifier() throws Exception {
		Assert.assertTrue(m.getIdentifier() == unitId);
	}

	@Test
	public void testFromBase() throws Exception {
		Meter m2 = new MeterImpl(value + 5, dimension, unitId, interfaceClass, dynamicCache, staticCache);
		Assert.assertEquals(m.fromBase(m2).getValue(), value + 5, 10E-6);
	}

	@Test
	public void testToBase() throws Exception {
		Assert.assertEquals(m.toBase().getValue(), value, 10E-6);
	}

	@Test
	public void testValueOf() throws Exception {
		m = new MeterImpl(value, dimension, unitId, interfaceClass, null, staticCache);
		Meter _this = m.valueOf(m.getValue());
		Assert.assertTrue(m == _this);
		
		Meter staticCached1 = m.valueOf(2);
		Meter staticCached2 = m.valueOf(2);
		Assert.assertTrue(staticCached1 == staticCached2);
		
		m = new MeterImpl(value, dimension, unitId, interfaceClass, dynamicCache, null);
		double oneThird = 1d / 3d;
		Meter dynCache1 =  m.valueOf(oneThird);
		Meter dynCache2 =  m.valueOf(oneThird);
		Assert.assertTrue(dynCache1 == dynCache2);
		
		m = new MeterImpl(oneThird, dimension, unitId, interfaceClass, null, null);
		Meter sameInstance = m.valueOf(oneThird);
		Assert.assertTrue(m == sameInstance);
		
		double twoThird = 2d /  3d;
		Meter m2 = m.valueOf(twoThird);
		Meter notSame = m.valueOf(twoThird);
		Assert.assertTrue(m2 != notSame);
		
	}

	@Test
	public void testGetValue() throws Exception {
		Assert.assertEquals(m.getValue(), value, 10E-6);
	}

	@Test
	public void testEquals() throws Exception {
		Meter m2 = new MeterImpl(value, dimension, unitId, interfaceClass, dynamicCache, staticCache);
		Assert.assertEquals(m, m2);
		
		Meter m3 = new MeterImpl(value + 1, dimension, unitId, interfaceClass, dynamicCache, staticCache);
		Assert.assertFalse(m.equals(m3));
		
		Assert.assertFalse(m.equals(null));
		
		Inch in = new InchImpl(value);
		Assert.assertFalse(m.equals(in));
	}

	@Test
	public void testToString() throws Exception {
		Assert.assertTrue("Expected was " + m.toString(), m.toString().equals("Meter [value=5.0]"));
	}

	@Test
	public void test_this() throws Exception {
		MeterImpl mi = new MeterImpl(value, dimension, unitId, interfaceClass, dynamicCache, staticCache);
		Meter m2 = mi._this();
		
		Assert.assertTrue(mi == m2);
	}

	@Test
	public void test_new_instance() throws Exception {
		MeterImpl mi = new MeterImpl(value, dimension, unitId, interfaceClass, dynamicCache, staticCache);
		Meter m2 = mi.valueOf(value);
		Assert.assertTrue(mi == m2);
		
		Meter m3 = mi._new_instance(value);
		Assert.assertTrue(mi != m3);
	}
}