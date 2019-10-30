package language.sections

import language.ast.TokensStatic
import lib.matcher.TestableStatic
import lib.matcher.items.ItemsStatic
import lib.matcher.sections.RepetitiveSectionStatic

class RepetitiveBySection : lib.matcher.sections.RepetitiveBySection<String> {

    var considerSeparation: Boolean = false

    constructor(vararg sections: TestableStatic<String>, considerSeparation: Boolean = false, minCount: Int = 0, maxCount: Int = RepetitiveSectionStatic.maxCount) :
            super(*sections, minCount = minCount, maxCount = maxCount) {
        this.considerSeparation = considerSeparation
    }

    override fun test(items: ItemsStatic.Class<String>): Boolean {
        return if (items is TokensStatic.Class) {
            val considerSeparation = items.considerSeparation
            items.considerSeparation = this.considerSeparation
            val test = super.test(items)
            items.considerSeparation = considerSeparation

            test
        } else false
    }

    constructor(vararg sections: TestableStatic<String>, by: TestableStatic<String>) : super(*sections, by = by)

}