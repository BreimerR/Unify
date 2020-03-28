package language.sections

import System
import language.ast.TokensStatic
import lib.matcher.TestableStatic
import lib.matcher.items.ItemsStatic

open class NotSection(
        vararg sections: TestableStatic<String>,
        val considerSeparation: Boolean = false,
        val considerSpaces: Boolean = false,
        val considerNewLines: Boolean = false
) : lib.matcher.sections.NotSectionStatic<String>(*sections) {

    override infix fun test(items: ItemsStatic.Class<String>): Boolean {
        return if (items is TokensStatic.Class) {
            items.saveState

            items.updateStates(
                    considerSpaces,
                    considerNewLines,
                    considerSeparation
            )

            val test = super.test(items)

            items.restoreState

            if (System.DEBUG) println("NotSection = $test \t token =  ${items.token}  \t token.value = ${items.token?.value}")

            if (System.DEBUG_POSITIVES && test) println("PassiveSection Returns $test \t token =  ${items.token}  \t token.value = ${items.token?.value}")

            test
        } else true
    }
}