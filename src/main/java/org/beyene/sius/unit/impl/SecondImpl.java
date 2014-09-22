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
import org.beyene.sius.dimension.Time;
import org.beyene.sius.unit.UnitIdentifier;
import org.beyene.sius.unit.time.Second;
import org.beyene.sius.util.Preferences;

final class SecondImpl extends AbstractUnit<Time, Second, Second> implements Second {

	private static final transient Cache<Time, Second, Second> dynamicCache;
	private static final transient StaticCache<Time, Second, Second> staticCache;
	
	static {
		int sizeDyn = Preferences.getInt("second.cache.dynamic.size", 0);
		if (sizeDyn > 0)
			dynamicCache = Caches.newInstance(UnitIdentifier.SECOND, Math.abs((sizeDyn)));
		else
			dynamicCache = null;

		int sizeStatic = Preferences.getInt("second.cache.static.size", 0);
		if (sizeStatic > 0)
			staticCache = new StaticCache<>(Preferences.getInt("second.cache.static.low", 0), sizeStatic, SecondImpl.class);
		else
			staticCache = null;
	}

	public SecondImpl(double value) {
		super(value, Time.INSTANCE, UnitIdentifier.SECOND, Second.class, dynamicCache, staticCache);
	}

	@Override
	public Second fromBase(Second base) {
		return valueOf(base.getValue());
	}
	
	@Override
	public Second toBase() {
		return this;
	}

	@Override
	protected Second _this() {
		return this;
	}

	@Override
	protected Second _new_instance(double value) {
		return new SecondImpl(value);
	}
}