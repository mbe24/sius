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
package org.beyene.sius.operation;

import org.beyene.sius.dimension.Dimension;
import org.beyene.sius.unit.Unit;
import org.beyene.sius.unit.UnitFactory;
import org.beyene.sius.unit.UnitId;

final class Converter {
	private Converter() {
		// private constructor to prevent instantiation
	}

	/**
	 * Converts a unit into another unit of the same dimension.
	 * 
	 * @param op operand
	 * @param targetId conversion unit id
	 * @return converted unit
	 */
	public static <D extends Dimension<D>, B extends Unit<D, B, B>, TARGET_UNIT extends Unit<D, B, TARGET_UNIT>>
	TARGET_UNIT convert(Unit<D, B, ?> op, UnitId<D, B, TARGET_UNIT> targetId) {
		TARGET_UNIT conversionUnit = UnitFactory.valueOf(0, targetId);
		
//		if (targetId.getInterface().isAssignableFrom(op.getClass()))
//			return targetId.getInterface().cast(op);
		
		if (conversionUnit.getIdentifier().equals(op.getIdentifier()))
			return conversionUnit.valueOf(op.getValue());
		
		return conversionUnit.fromBase(op.toBase());
	}
}