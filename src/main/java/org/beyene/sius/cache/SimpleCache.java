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

import java.util.Collections;
import java.util.Map;
import java.util.WeakHashMap;

import org.beyene.sius.dimension.Dimension;
import org.beyene.sius.unit.Unit;

final class SimpleCache<D extends Dimension<D>, B extends Unit<D, B, B>, U extends Unit<D, B, U>>
		implements Cache<D, B, U> {

	private final int capacity;
	private final Map<Double, U> map;

	SimpleCache(int capacity) {
		this.capacity = capacity;
		this.map = Collections.synchronizedMap(new WeakHashMap<Double, U>());
	}

	@Override
	public U lookUp(double d) {
		return map.get(d);
	}

	@Override
	public boolean put(U unit) {
		if (map.size() >= capacity && !map.containsKey(unit.getScalar())) {
			return false;
		} else {
			map.put(unit.getScalar(), unit);
			return true;
		}
	}
}