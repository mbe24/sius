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

import java.lang.reflect.Array;
import java.lang.reflect.InvocationTargetException;

import org.beyene.sius.dimension.Dimension;
import org.beyene.sius.unit.Unit;

/* static cache inspired by java.lang.Integer */
public class StaticCache<D extends Dimension<D>, BASE extends Unit<D, BASE, BASE>, SELF extends Unit<D, BASE, SELF>> {

	public final SELF[] cache;
	public final int low;
	public final int high;

	@SuppressWarnings("unchecked")
	public StaticCache(
			int low, 
			int size,
			Class<? extends Unit<D, BASE, SELF>> implementingClass) {
		
		this.low = low;
		this.high = Math.abs(size - 1);

		cache = (SELF[]) Array.newInstance(implementingClass, (high - low) + 1);
		int j = low;
		for (int k = 0; k < cache.length; k++)
			try {
				cache[k] = (SELF) implementingClass.getDeclaredConstructor(double.class).newInstance(j++);
			} catch (InstantiationException e) {
				throw new IllegalStateException(e);
			} catch (IllegalAccessException e) {
				throw new IllegalStateException(e);
			} catch (IllegalArgumentException e) {
				throw new IllegalStateException(e);
			} catch (InvocationTargetException e) {
				throw new IllegalStateException(e);
			} catch (NoSuchMethodException e) {
				throw new IllegalStateException(e);
			} catch (SecurityException e) {
				throw new IllegalStateException(e);
			}
	}
}