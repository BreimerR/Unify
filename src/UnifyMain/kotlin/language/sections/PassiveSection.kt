package language.sections

import language.ast.TokensStatic
import lib.matcher.TestableStatic
import lib.matcher.items.ItemsStatic
import lib.matcher.sections.SectionStatic

open
class PassiveSection(vararg sections: TestableStatic<String>, val considerSeparations: Boolean = false) :
        SectionStatic<String>(*sections) {

    var test: Boolean = false

    override fun test(items: ItemsStatic.Class<String>): Boolean {
        return if (items is TokensStatic.Class) {
            val i = items.i
            val cSeparations = items.considerSeparation
            items.considerSeparation = considerSeparations
            test = super.test(items)
            items.i = i

            items.considerSeparation = cSeparations

            println("passive = ")
            print(test)
            test
        } else false
    }
}