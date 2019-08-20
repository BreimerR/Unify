package lib.matcher.sections

import lib.matcher.TestableStatic

abstract class OneOrManySectionStatic<T>(minCount: Int = 1) : RepetitiveSectionStatic<T>(minCount = minCount) {

    abstract override fun invoke(vararg items: TestableStatic.Class<T>, name: String?): Class<T>

    abstract fun invoke(item: TestableStatic.Class<T>, name: String?, maxCount: Int = this.maxCount): Class<T>

    open class Class<T>(vararg section: TestableStatic.Class<T>, name: String?, self: OneOrManySectionStatic<T>, maxCount: Int = 10000) :
            RepetitiveSectionStatic.Class<T>(*section, name = name, minCount = self.minCount, maxCount = maxCount, self = self)
}