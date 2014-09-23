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
package org.beyene.sius.cache;

import org.beyene.sius.dimension.Time;
import org.beyene.sius.unit.impl.FactoryTime;
import org.beyene.sius.unit.time.Hour;
import org.beyene.sius.unit.time.Minute;
import org.beyene.sius.unit.time.Second;
import org.junit.Assert;
import org.junit.Test;

public class SimpleCacheTest {

	@Test
	public void testLookUp() throws Exception {
		SimpleCache<Time, Second, Hour> cache = new SimpleCache<Time, Second, Hour>(5);

		double value = 5;
		Hour h = FactoryTime.hour(value);
		cache.put(h);

		Assert.assertNotNull(cache.lookUp(value));
		Assert.assertEquals((int) h.getValue(), (int) cache.lookUp(value).getValue());
	}

	@Test
	public void testPut() throws Exception {
		int size = 10;
		SimpleCache<Time, Second, Minute> cache = new SimpleCache<Time, Second, Minute>(size);

		int min = 1000;
		boolean flag = true;
		for (int i = 0; i < 2 * size; i++) {
			if (i >= size)
				flag = false;
			Assert.assertEquals(flag, cache.put(FactoryTime.minute(min++)));
		}
	}
}