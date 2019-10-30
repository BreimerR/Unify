package lib.matcher.sections

import lib.matcher.TestableStatic
import lib.matcher.items.ItemsStatic


abstract class AlternativeSectionStatic<T>(vararg sections: TestableStatic<T>) : SectionStatic<T>(*sections) {

    override fun test(items: ItemsStatic.Class<T>): Boolean {
        var eI: Int = items.i

        for (section in sections) {

            val i = items.i

            var test = section test items

            eI = items.i

            if (test) {

                when (section) {
                    is RepetitiveSectionStatic<T> -> {
                        test = section.test
                    }

                    is OptionalSectionStatic<T> -> {
                        test = section.test
                    }
                }

                if (test) return true

            }
            // revert i for re test
            items.i = i
        }

        items.i = eI

        return false
    }

}

