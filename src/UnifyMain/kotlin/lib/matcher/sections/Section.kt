package lib.matcher.sections

import lib.matcher.TestableStatic
import lib.matcher.items.ItemsStatic

abstract class SectionStatic<T> : TestableStatic {

    abstract fun invoke(vararg sections: TestableStatic, name: String? = null): Class<T>


    abstract class Class<T>(open vararg val sections: TestableStatic, val name: String? = null) : TestableStatic.Class<T>() {
        override fun test(items: ItemsStatic.Class<T>): Boolean {
            return false
        }
    }

}