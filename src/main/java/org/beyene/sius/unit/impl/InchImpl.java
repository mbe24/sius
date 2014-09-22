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
import org.beyene.sius.unit.UnitIdentifier;
import org.beyene.sius.unit.length.Constants;
import org.beyene.sius.unit.length.Inch;
import org.beyene.sius.unit.length.Meter;
import org.beyene.sius.util.Preferences;

final class InchImpl extends AbstractUnit<Length, Meter, Inch> implements Inch {

	private static final transient Cache<Length, Meter, Inch> dynamicCache;
	private static final transient StaticCache<Length, Meter, Inch> staticCache;
	
	static {
		int sizeDyn = Preferences.getInt("inch.cache.dynamic.size", 0);
		if (sizeDyn > 0)
			dynamicCache = Caches.newInstance(UnitIdentifier.INCH, Math.abs((sizeDyn)));
		else
			dynamicCache = null;

		int sizeStatic = Preferences.getInt("inch.cache.static.size", 0);
		if (sizeStatic > 0)
			staticCache = new StaticCache<>(Preferences.getInt("inch.cache.static.low", 0), sizeStatic, InchImpl.class);
		else
			staticCache = null;
	}
	
	public InchImpl(double value) {
		super(value, Length.INSTANCE, UnitIdentifier.INCH, Inch.class, dynamicCache, staticCache);
	}

	@Override
	public Inch fromBase(Meter base) {
		return valueOf(base.getValue() / Constants.METER_PER_INCH);
	}

	@Override
	public Meter toBase() {
		return FactoryLength.meter(value * Constants.METER_PER_INCH);
	}

	@Override
	protected Inch _this() {
		return this;
	}

	@Override
	protected Inch _new_instance(double value) {
		return new InchImpl(value);
	}
}