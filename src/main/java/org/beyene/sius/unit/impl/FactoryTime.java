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

import org.beyene.sius.unit.time.Hour;
import org.beyene.sius.unit.time.Minute;
import org.beyene.sius.unit.time.Second;

public final class FactoryTime {
	private FactoryTime() {
		// private constructor to prevent instantiation
	}
	
	private static final Second second = new SecondImpl(0);
	public static Second second(double value) {
		return second.valueOf(value);
	}
	
	private static final Minute minute = new MinuteImpl(0);
	public static Minute minute(double value) {
		return minute.valueOf(value);
	}
	
	private static final Hour hour = new HourImpl(0);
	public static Hour hour(double value) {
		return hour.valueOf(value);
	}
}