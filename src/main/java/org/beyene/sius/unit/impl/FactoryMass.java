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

import org.beyene.sius.unit.mass.KiloGram;
import org.beyene.sius.unit.mass.Pound;

public final class FactoryMass {
	private FactoryMass() {
		// private constructor to prevent instantiation
	}

	private static final KiloGram kg = new KiloGramImpl(0).valueOf(0);
	public static KiloGram kg(double value) {
		return kg.valueOf(value);
	}

	private static final Pound pound = new PoundImpl(0).valueOf(0);
	public static Pound lb(double value) {
		return pound.valueOf(value);
	}
}