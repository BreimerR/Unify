package language.sections

import lib.matcher.TestableStatic
import lib.matcher.items.ItemsStatic
import lib.matcher.sections.SectionStatic

class RepetitiveBySection<T>(
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

    var count = 0

    val validity
        get() = count > 0

    override fun test(items: ItemsStatic.Class<T>): Boolean {


        /**TODO
         * add spaces state
         * */
        var test = super.test(items)

        /**TODO
         * restore spaces state
         * */
        while (test) {
            count += 1
            val indexBeforeShouldContinue = items.nextIndex
            if (shouldContinue(items)) {
                test = super.test(items)
                if (!test) {
                    items.nextIndex = indexBeforeShouldContinue
                    break
                }
            } else {
                items.nextIndex = indexBeforeShouldContinue
                break;
            }
        }

        return validity
    }

    private fun shouldContinue(items: ItemsStatic.Class<T>): Boolean = by test items

    fun testRecurring(items: ItemsStatic.Class<T>): Boolean = by test items && super.test(items)

    infix fun doTest(items: ItemsStatic.Class<T>): Boolean = doTest(items, this)

}

