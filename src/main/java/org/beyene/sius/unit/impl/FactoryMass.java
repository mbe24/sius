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

	public static KiloGram kg(double value) {
		return new KiloGramImpl(value);
	}

	public static Pound lb(double value) {
		return new PoundImpl(value);
	}
}