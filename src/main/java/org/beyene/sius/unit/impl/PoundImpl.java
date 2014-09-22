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
import org.beyene.sius.dimension.Mass;
import org.beyene.sius.unit.UnitIdentifier;
import org.beyene.sius.unit.mass.Constants;
import org.beyene.sius.unit.mass.KiloGram;
import org.beyene.sius.unit.mass.Pound;
import org.beyene.sius.util.Preferences;

final class PoundImpl extends AbstractUnit<Mass, KiloGram, Pound> implements Pound {

	private static final transient Cache<Mass, KiloGram, Pound>  dynamicCache;
	private static final transient StaticCache<Mass, KiloGram, Pound>  staticCache;
	
	static {
		int sizeDyn = Preferences.getInt("pound.cache.dynamic.size", 0);
		if (sizeDyn > 0)
			dynamicCache = Caches.newInstance(UnitIdentifier.POUND, Math.abs((sizeDyn)));
		else
			dynamicCache = null;

		int sizeStatic = Preferences.getInt("pound.cache.static.size", 1);
		if (sizeStatic > 0)
			staticCache = new StaticCache<>(Preferences.getInt("pound.cache.static.low", 0), sizeStatic, PoundImpl.class);
		else
			staticCache = null;
	}
	
	public PoundImpl(double value) {
		super(value, Mass.INSTANCE, UnitIdentifier.POUND, Pound.class, dynamicCache, staticCache);
	}

	@Override
	public Pound fromBase(KiloGram base) {
		return valueOf(base.getValue() / Constants.KILOGRAM_PER_POUND);
	}

	@Override
	public KiloGram toBase() {
		return FactoryMass.kg(value * Constants.KILOGRAM_PER_POUND);
	}

	@Override
	protected Pound _this() {
		return this;
	}

	@Override
	protected Pound _new_instance(double value) {
		return new PoundImpl(value);
	}
}