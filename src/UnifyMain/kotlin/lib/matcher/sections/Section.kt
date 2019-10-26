package lib.matcher.sections

import lib.matcher.TestableStatic
import lib.matcher.items.ItemsStatic

abstract class SectionStatic<T> : TestableStatic<T> {

    abstract fun invoke(vararg sections: TestableStatic<T>, name: String? = null): Class<T>

    override fun test(items: ItemsStatic.Class<T>): Boolean {
        return false
    }

    abstract class Class<T>(open vararg val sections: TestableStatic<T>, val name: String? = null) : TestableStatic.Class<T>()

}