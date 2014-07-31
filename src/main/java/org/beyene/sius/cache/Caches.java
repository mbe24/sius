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

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.beyene.sius.dimension.Dimension;
import org.beyene.sius.unit.Unit;
import org.beyene.sius.unit.UnitId;

public final class Caches {

	private static Map<String, Provider> providers = new ConcurrentHashMap<>();
	private static String DEFAULT_PROVIDER_NAME = "<def>";

	static {
		providers.put(DEFAULT_PROVIDER_NAME, new SimpleProvider());
	}

	private Caches() {
		// private constructor to prevent instantiation
	}

	/* TODO */
	public static <D extends Dimension<D>, B extends Unit<D, B, B>, U extends Unit<D, B, U>> Cache<D, B, U> newInstance(
			String name, UnitId<D, B, U> id) {
		return null;
	}

	public static <D extends Dimension<D>, B extends Unit<D, B, B>, U extends Unit<D, B, U>> Cache<D, B, U> newInstance(
			UnitId<D, B, U> id, int capacity) {
		Provider p = providers.get(DEFAULT_PROVIDER_NAME);
		return p.newInstance(id, capacity);
	}
}