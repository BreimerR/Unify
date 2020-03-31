package lib.matcher.sections

import lib.matcher.TestableStatic
import lib.matcher.items.ItemsStatic

// TODO  var sections should be open val sections instead
open class SectionStatic<T>(open vararg var sections: TestableStatic<T>, val name: String? = null) : TestableStatic<T>() {

    override infix fun test(items: ItemsStatic.Class<T>): Boolean {

        for (section in sections) {

            val test = section test items

            if (!test) return false
        }

        return sections.isNotEmpty()
    }

}

