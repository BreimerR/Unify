package lib.matcher.sections

import lib.matcher.TestableStatic


open class ZeroOrManyStatic<T>(vararg sections: TestableStatic<T>, maxCount: Int = RepetitiveSectionStatic.maxCount, name: String? = null) : RepetitiveSectionStatic<T>(*sections, minCount = 0, maxCount = maxCount, name = name)