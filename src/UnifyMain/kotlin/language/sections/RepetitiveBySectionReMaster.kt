package language.sections

import lib.matcher.TestableStatic
import lib.matcher.items.ItemsStatic
import lib.matcher.sections.SectionStatic

class RepetitiveBySectionReMaster<T>(
    val by: TestableStatic<T>,
    vararg sections: TestableStatic<T>,
    name: String = "RepetitiveBySectionReMaster",
) :
    SectionStatic<T>(*sections, name = name) {

    // Self
    // AlternativeSection
    // EndsWithSection
    // MixedOrderSection
    // NotSection
    // OneOrManySection
    // PassiveSection
    // RepetitiveSection
    // Section
    // zeroOrMAny

    override fun test(items: ItemsStatic.Class<T>): Boolean {

        var test = super.test(items)

        while (test) {
            val indexBeforeShouldContinue = items.nextIndex
            if (shouldContinue(items)) {
                test = super.test(items)
            } else {
                items.nextIndex = indexBeforeShouldContinue
                break;
            }
        }

        return test
    }

    fun shouldContinue(items: ItemsStatic.Class<T>): Boolean {
        return by test items
    }

    fun testRecurring(items: ItemsStatic.Class<T>): Boolean {
        return by test items && super.test(items)
    }

    infix fun doTest(items: ItemsStatic.Class<T>): Boolean {

        for (section in sections) {

            Log.d(TAG, "Start token = " + items.currentItem.toString())

            val test = section test items

            Log.d(TAG, "End token = " + items.currentItem.toString())

            if (!test) return false
        }

        return sections.isNotEmpty()
    }


}