package lib.matcher.sections

import lib.matcher.TestableStatic
import lib.matcher.items.ItemsStatic

// TODO  var sections should be open val sections instead
// sections should be converted to val to avoid having empty set body
open class SectionStatic<T>(open vararg var sections: TestableStatic<T>, open val name: String? = null) : TestableStatic<T>() {

    open val TAG get() = (this::class.simpleName ?: "SectionStatic") + if (name != null) "($name)" else ""

    override infix fun test(items: ItemsStatic.Class<T>): Boolean {

        for (section in sections) {

            Log.d(TAG, "Start token = " + items.currentItem.toString())

            val test = section test items

            Log.d(TAG, "End token = " + items.currentItem.toString())

            if (!test) return false
        }

        return sections.isNotEmpty()
    }

}

