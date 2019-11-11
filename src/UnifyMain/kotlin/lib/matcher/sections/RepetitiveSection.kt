package lib.matcher.sections

import lib.matcher.TestableStatic
import lib.matcher.items.ItemsStatic

open class RepetitiveSectionStatic<T>(vararg sections: TestableStatic<T>, val minCount: Int = 1, val maxCount: Int = RepetitiveSectionStatic.maxCount) : SectionStatic<T>(*sections) {

    private var tCounts = 0

    var test: Boolean = true

    private inline val minSuccess: Boolean
        get() = tCounts >= minCount

    override fun test(items: ItemsStatic.Class<T>): Boolean {
        var i: Int = items.i



        // TODO maxCount error fix required
        recurTest@ while (tCounts < maxCount + 1) {
            i = items.i

            val prevT = test

            test = singleTest(items)

            if (items.i <= i || !test) {

                test = prevT
                break@recurTest
            }

            tCounts += 1

        }

        return if (minCount <= 0) {
            items.i = i
            true
        } else {
            test
        }
    }

    // TODO stop self when min = zero
    protected open fun singleTest(items: ItemsStatic.Class<T>): Boolean {

        var truth = false

        testLoop@ for (section in sections) {
            truth = section test items

            if (truth) {
                //
            } else break@testLoop

        }

        return truth
    }

    companion object {
        val maxCount = 10000
    }

}

