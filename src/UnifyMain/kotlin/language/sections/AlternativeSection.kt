package language.sections

import System
import language.ast.TokensStatic
import lib.matcher.TestableStatic
import lib.matcher.items.ItemsStatic
import lib.matcher.sections.AlternativeSectionStatic as BaseAlternativeSectionStatic

open class AlternativeSection(
        vararg sections: TestableStatic<String>,
        private val considerSeparation: Boolean = false,
        private val considerSpaces: Boolean = false,
        private val considerNewLine: Boolean = false
) : BaseAlternativeSectionStatic<String>(*sections) {

    override fun test(items: ItemsStatic.Class<String>): Boolean {

        return if (items is TokensStatic.Class) {
            items.saveState

            items.updateStates(
                    considerSpaces,
                    considerNewLine,
                    considerSeparation
            )

            val test = super.test(items)

            items.restoreState

            if (System.DEBUG) println("Alternative Returns $test \t token =  ${items.token}  \t token.value = ${items.token?.value}")

            if (System.DEBUG_POSITIVES && test) println("PassiveSection Returns $test \t token =  ${items.token}  \t token.value = ${items.token?.value}")

            test

        } else super.test(items)

    }
}