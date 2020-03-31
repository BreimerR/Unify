package lib.matcher.sections

import lib.matcher.TestableStatic
import lib.matcher.items.ItemsStatic

open class NotSectionStatic<T>(vararg sections: TestableStatic<T>) : SectionStatic<T>(*sections) {
    override infix fun test(items: ItemsStatic.Class<T>): Boolean {
        val i = items.nextIndex
        val test = super.test(items)

        return if (test) {
            items.nextIndex = i
            false
        } else true
    }
}