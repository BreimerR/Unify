package language.sections

import language.ast.TokensStatic
import lib.matcher.TestableStatic
import lib.matcher.items.ItemsStatic
import lib.matcher.sections.RepetitiveSectionStatic

class RepetitiveBySection(vararg sections: TestableStatic<String>, var considerSeparation: Boolean = false, minCount: Int = 0, maxCount: Int = RepetitiveSectionStatic.maxCount) :
        lib.matcher.sections.RepetitiveBySection<String>(*sections, minCount = minCount, maxCount = maxCount) {

    override fun test(items: ItemsStatic.Class<String>): Boolean {
        return if (items is TokensStatic.Class) {
            val considerSeparation = items.considerSeparation
            items.considerSeparation = this.considerSeparation
            val test = super.test(items)
            items.considerSeparation = considerSeparation

            test
        } else false
    }


}