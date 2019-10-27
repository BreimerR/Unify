package language.sections

import lib.matcher.TestableStatic
import lib.matcher.items.ItemsStatic

open class SectionStatic<T> : TestableStatic {


    open operator fun invoke(vararg sections: TestableStatic.Class<T>): Class<T> = Class(*sections)

    open class Class<T>(vararg val sections: TestableStatic.Class<T>) : TestableStatic.Class<T>() {

        override val self by lazy {
            Section
        }

        override infix fun test(items: ItemsStatic.Class<T>): Boolean {

            sections.forEach {

                if (it fail items)
                    return false
                else {
                    // code for collection

                }
            }

            return true
        }


    }
}

val Section = SectionStatic<String>()


