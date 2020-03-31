package lib.matcher.sections

import lib.matcher.TestableStatic


open class ZeroOrManyStatic<T>(vararg sections: TestableStatic<T>, maxCount: Int = RepetitiveSectionStatic.maxCount) : RepetitiveSectionStatic<T>(*sections, minCount = 0, maxCount = maxCount)