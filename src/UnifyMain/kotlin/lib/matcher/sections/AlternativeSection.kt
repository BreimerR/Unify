package lib.matcher.sections

import lib.collections.array.pop
import lib.matcher.TestableStatic
import lib.matcher.items.ItemsStatic


abstract class AlternativeSectionStatic<T>(override vararg var sections: TestableStatic<T>) : SectionStatic<T>(*sections) {

    override fun test(items: ItemsStatic.Class<T>): Boolean {

        var eI: Int = items.i

        var sI = 0

        for (section in sections) {

            val i = items.i

            var test = section test items

            eI = items.i

            if (test) {

                when (section) {

                    is RepetitiveSectionStatic<T> -> test = section.test

                    is OptionalSectionStatic<T> -> test = section.test

                    is SingleInstanceSection<T> -> {
                        if (test) sections = sections.pop(sI).toTypedArray()
                        sI = 0
                    }

                }
                // TODO save found section to avoid re test on collection

                if (test) return true

            }
            sI += 1;
            // revert i for re test
            items.i = i

        }

        items.i = eI

        return false
    }

}

