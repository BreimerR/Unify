package language.sections

import lib.matcher.TestableStatic
import lib.matcher.items.ItemsStatic
import lib.matcher.sections.SectionStatic

class RepetitiveBySectionReMaster<T>(
    val by: TestableStatic<T>,
    vararg sections: TestableStatic<T>,
    name: String = "RepetitiveBySectionReMaster",
    val considerSeparations: Boolean = false,
) : SectionStatic<T>(*sections, name = name) {

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

        /**TODO
         * add spaces state
         * */
        var test = super.test(items)

        /**TODO
         * restore spaces state
         * */
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

    private fun shouldContinue(items: ItemsStatic.Class<T>): Boolean = by test items

    fun testRecurring(items: ItemsStatic.Class<T>): Boolean = by test items && super.test(items)

    infix fun doTest(items: ItemsStatic.Class<T>): Boolean = doTest(items, this)

}

