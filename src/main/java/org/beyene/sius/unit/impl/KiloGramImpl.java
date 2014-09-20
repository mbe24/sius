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
import org.beyene.sius.unit.Unit;
import org.beyene.sius.unit.UnitIdentifier;
import org.beyene.sius.unit.mass.KiloGram;
import org.beyene.sius.util.Preferences;

final class KiloGramImpl extends AbstractUnit<Mass, KiloGram, KiloGram> implements KiloGram {

	private static final transient Cache<Mass, KiloGram, KiloGram> dynamicCache;
	private static final transient StaticCache<Mass, KiloGram, KiloGram> staticCache;
	
	static {
		int sizeDyn = Preferences.loadInt("kg.cache.dynamic.size", 0);
		if (sizeDyn > 0)
			dynamicCache = Caches.newInstance(UnitIdentifier.KILOGRAM, Math.abs((sizeDyn)));
		else
			dynamicCache = null;

		int sizeStatic = Preferences.loadInt("kg.cache.static.size", 0);
		if (sizeStatic > 0)
			staticCache = new StaticCache<>(Preferences.loadInt("kg.cache.static.low", 0), sizeStatic, KiloGramImpl.class);
		else
			staticCache = null;
	}
	
	public KiloGramImpl(double value) {
		super(value, Mass.INSTANCE, UnitIdentifier.KILOGRAM, KiloGram.class, KiloGram.class, dynamicCache, staticCache);
	}

	@Override
	protected KiloGram fromBase(Unit<Mass, KiloGram, KiloGram> base) {
		return valueOf(base.getValue());
	}

	@Override
	public KiloGram toBaseUnit() {
		return this;
	}

	@Override
	protected KiloGram _this() {
		return this;
	}

	@Override
	protected KiloGram _new_instance(double value) {
		return new KiloGramImpl(value);
	}
}