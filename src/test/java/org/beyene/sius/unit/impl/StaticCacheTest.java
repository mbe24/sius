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

import org.beyene.sius.dimension.Length;
import org.beyene.sius.unit.length.Inch;
import org.beyene.sius.unit.length.Meter;
import org.junit.Assert;
import org.junit.Test;

public class StaticCacheTest {

	@Test()
	public void testCtor1() throws Exception {
		int low = -5;
		int size = 10;
		StaticCache<Length, Meter, Inch> staticCache = new StaticCache<>(low,
				size, InchImpl.class);

		int start = low;
		for (Inch in : staticCache.cache) {
			Assert.assertTrue((int) in.getValue() == start++);
		}
	}

	@Test(expected = IllegalStateException.class)
	public void testCtor2() throws Exception {
		@SuppressWarnings("unused")
		StaticCache<Length, Meter, Inch> staticCache = new StaticCache<>(0, 5, Inch.class);
		Assert.fail("Class parameter has to be class of an interface to throw the expected exception!");
	}
}