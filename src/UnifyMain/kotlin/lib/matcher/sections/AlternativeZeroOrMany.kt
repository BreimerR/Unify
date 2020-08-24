package lib.matcher.sections

import lib.collections.array.pop
import lib.matcher.TestableStatic
import lib.matcher.items.ItemsStatic

class AlternativeZeroOrMany<T>(vararg sections: TestableStatic<T>, maxCount: Int = RepetitiveSectionStatic.maxCount) : RepetitiveSectionStatic<T>(*sections, minCount = 0, maxCount = maxCount) {

    override fun singleTest(items: ItemsStatic.Class<T>): Boolean {
        var sections = this.sections

        var eI: Int = items.nextIndex

        var sI = 0

        for (section in sections) {

            sI += 1;

            val i = items.nextIndex

            Log.d(TAG, "Start token = " + items.currentItem.toString())

            var test = section test items

            Log.d(TAG, "End token = " + items.currentItem.toString())

            eI = items.nextIndex

            if (test) {

                when (section) {
                    is RepetitiveSectionStatic<T> -> test = section.test


                    is OptionalSectionStatic<T> -> test = section.test

                    is SingleInstanceSection<T> -> if (test) sections = sections.pop(sI).toTypedArray()

                }

                // TODO save found section to avoid re test on collection

                if (test) return true

            }
            // revert i for re test
            items.nextIndex = i
        }

        items.nextIndex = eI

        return false
    }
}