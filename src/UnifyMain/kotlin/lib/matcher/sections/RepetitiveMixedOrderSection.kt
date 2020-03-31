package lib.matcher.sections

import language.sections.Section
import lib.matcher.TestableStatic
import lib.matcher.items.ItemsStatic

class RepetitiveMixedOrderSection<T>(
        vararg sections: TestableStatic<T>,
        val minCount: Int = 0,
        val maxCount: Int = RepetitiveSectionStatic.maxCount
) :
        SectionStatic<T>(*sections) {

    override fun test(items: ItemsStatic.Class<T>): Boolean {

        var testable = true


        while (testable) {
            for (section in sections) {
                val test = section test items

                if (test) {

                }
            }
        }

        return false
    }
}