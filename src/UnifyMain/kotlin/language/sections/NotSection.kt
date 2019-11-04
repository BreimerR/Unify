package language.sections

import language.ast.TokensStatic
import lib.matcher.TestableStatic
import lib.matcher.items.ItemsStatic

open class NotSection(vararg sections: TestableStatic<String>, val considerSeparation: Boolean = false) : lib.matcher.sections.NotSectionStatic<String>(*sections) {

    override infix fun test(items: ItemsStatic.Class<String>): Boolean {
        return if (items is TokensStatic.Class) {
            val cSeparations = items.considerSeparation
            items.considerSeparation = considerSeparation
            val test = super.test(items)
            items.considerSeparation = cSeparations
            test
        } else true
    }
}