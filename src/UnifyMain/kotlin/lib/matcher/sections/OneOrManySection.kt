package lib.matcher.sections

import lib.matcher.TestableStatic
import kotlin.math.max

class OneOrManySection<T>(
        vararg sections: TestableStatic<T>,
        name: String? = null,
        minCount: Int = 1,
        maxCount: Int = 50000) :
        RepetitiveSection<T>(*sections, name = name, minCount = minCount, maxCount = maxCount)