package lib.matcher.sections


import lib.matcher.TestableStatic
import lib.matcher.items.ItemsStatic.Class as ItemsClass


abstract class NotSectionStatic<T> : SectionStatic<T>() {

    abstract class Class<I>(vararg items: TestableStatic.Class<I>, name: String? = null, self: NotSectionStatic<I>) :
            SectionStatic.Class<I>(*items, name = name, self = self) {


        // search algo required here to make the loop not linear exactly for performance boost
        override fun test(items: ItemsClass<I>): Boolean {
            sections.forEach {
                if (it test items) return false
            }

            return true
        }
    }
}






