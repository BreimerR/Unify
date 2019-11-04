package language.sections

import language.ast.TokensStatic
import lib.matcher.TestableStatic
import lib.matcher.items.ItemsStatic
import lib.matcher.sections.SectionStatic

class PassiveSection(vararg sections: TestableStatic<String>, val considerSeparations: Boolean = false) : SectionStatic<String>(*sections) {

    override fun test(items: ItemsStatic.Class<String>): Boolean {
        return if (items is TokensStatic.Class) {
            val i = items.i
            val cSeparations = items.considerSeparation
            items.considerSeparation = considerSeparations
            val test = super.test(items)
            items.i = i
            items.considerSeparation = cSeparations

            test
        } else false
    }
}