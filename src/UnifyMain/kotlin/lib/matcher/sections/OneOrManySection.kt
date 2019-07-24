package lib.matcher.sections

import lib.matcher.TestableStatic

abstract class OneOrManySectionStatic<T>(minCount: Int = 1) : RepetitiveSectionStatic<T>(minCount = minCount) {

    abstract override fun invoke(vararg items: TestableStatic.Class<T>, name: String?): Class<T>

    abstract fun invoke(item: TestableStatic.Class<T>, name: String?, maxCount: Int = this.maxCount): Class<T>

    /*= Class(item, name, maxCount = this.maxCount)*/

    /*= Class(Section(*items), name, maxCount = this.maxCount)*/

    open class Class<T>(section: TestableStatic.Class<T>, name: String?, override val maxCount: Int, self: OneOrManySectionStatic<T>) :
            RepetitiveSectionStatic.Class<T>(section, name, self.minCount, maxCount, self)
}