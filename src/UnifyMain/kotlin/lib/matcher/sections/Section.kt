package lib.matcher.sections

import lib.matcher.TestableStatic
import lib.matcher.items.ItemsStatic

open class SectionStatic<T>(open vararg val sections: TestableStatic<T>) : TestableStatic<T>() {

    override infix fun test(items: ItemsStatic.Class<T>): Boolean {

        for (section in sections) {

            var test = section test items

            if (test) {
                when (section) {
                    is RepetitiveSectionStatic<T> -> {
                        test = section.test
                    }

                    is OptionalSectionStatic<T> -> {
                        test = section.test
                    }

                }


                if (test) {

                }
            } else return false
        }

        return sections.isNotEmpty()
    }

}

