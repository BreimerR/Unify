package language.sections

import language.ast.TokensStatic
import lib.matcher.TestableStatic
import lib.matcher.items.ItemsStatic

class AlternativeSection(vararg sections: TestableStatic<String>, private val considerSeparation: Boolean = false) : lib.matcher.sections.AlternativeSectionStatic<String>(*sections) {
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