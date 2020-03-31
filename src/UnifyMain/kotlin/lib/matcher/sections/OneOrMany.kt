package lib.matcher.sections

import lib.matcher.TestableStatic

open class OneOrManyStatic<T>(vararg sections: TestableStatic<T>, maxCount: Int = RepetitiveSectionStatic.maxCount) : RepetitiveSectionStatic<T>(*sections, minCount = 1, maxCount = maxCount)