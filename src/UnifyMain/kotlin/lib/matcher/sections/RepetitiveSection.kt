package lib.matcher.sections

import lib.matcher.TestableStatic
import lib.matcher.items.ItemsStatic

open class RepetitiveSectionStatic<T>(vararg sections: TestableStatic<T>, val minCount: Int = 0, val maxCount: Int = RepetitiveSectionStatic.maxCount) : SectionStatic<T>(*sections) {

    var tCounts = 0

    var test: Boolean = true

    private inline val testable
        get() = tCounts < maxCount

    private inline val minSuccess: Boolean
        get() = tCounts >= minCount

    override fun test(items: ItemsStatic.Class<T>): Boolean {
        var i: Int = items.i

        recurTest@ while (testable) {
            i = items.i

            test = tests(items)

            if (!test) break@recurTest

        }


        return if (minCount <= 0) {
            items.i = i
            true
        } else test
    }

    private fun tests(items: ItemsStatic.Class<T>): Boolean {

        var truth = false

        testLoop@ for (section in sections) {
            if (section test items) {

                truth = when (section) {
                    is RepetitiveSectionStatic<T> -> section.test
                    is OptionalSectionStatic<T> -> section.test
                    else -> true
                }

                if (!truth) break@testLoop

            } else break@testLoop

        }

        return truth
    }

    companion object {
        val maxCount = 10000
    }

}

