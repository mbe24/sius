package org.beyene.sius.dimension.composition.util;

import org.beyene.sius.dimension.Dimension;

public interface Composition<C1 extends Dimension<C1>, C2 extends Dimension<C2>, COMPOSITION extends Composition<C1, C2, COMPOSITION>>
		extends Dimension<COMPOSITION> {
}