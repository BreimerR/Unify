package language.sections

import language.ast.TokensStatic
import lib.matcher.TestableStatic
import lib.matcher.items.ItemsStatic

open class MixedOrderSection(vararg sections: TestableStatic<String>, val considerSeparations: Boolean = false) : lib.matcher.sections.MixedSectionStatic<String>(*sections) {
    override fun test(items: ItemsStatic.Class<String>): Boolean {
        return if (items is TokensStatic.Class) {
            val cSeparations = items.considerSeparation
            items.considerSeparation = considerSeparations
            val test = super.test(items)
            items.considerSeparation = cSeparations

            test
        } else false
    }
}