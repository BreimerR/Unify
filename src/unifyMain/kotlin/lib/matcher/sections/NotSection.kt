package lib.matcher.sections

import lib.matcher.TestableStatic
import lib.matcher.items.ItemsStatic

open class NotSectionStatic<T>(vararg sections: TestableStatic<T>, name: String? = null) : SectionStatic<T>(*sections, name = name) {
    override infix fun test(items: ItemsStatic.Class<T>): Boolean {
        val i = items.nextIndex

        Log.d(TAG, "Start token = " + items.currentItem.toString())
        val test = super.test(items)
        Log.d(TAG, "End token = " + items.currentItem.toString())

        return if (test) {
            items.nextIndex = i
            false
        } else true
    }
}