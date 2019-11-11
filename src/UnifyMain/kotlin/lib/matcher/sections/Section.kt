package lib.matcher.sections

import language.sections.ZeroOrMany
import lib.matcher.TestableStatic
import lib.matcher.items.ItemsStatic

open class SectionStatic<T>(open vararg var sections: TestableStatic<T>) : TestableStatic<T>() {

    override infix fun test(items: ItemsStatic.Class<T>): Boolean {

        for (section in sections) {

            val test = section test items

            if (!test) return false
        }

        return sections.isNotEmpty()
    }

}

