package language.sections

import System
import language.ast.TokensStatic
import lib.matcher.TestableStatic
import lib.matcher.items.ItemsStatic
import lib.matcher.sections.MixedSectionStatic as BaseMixedSectionStatic

open class MixedOrderSection(
        vararg sections: TestableStatic<String>,
        private val considerSeparations: Boolean = false,
        private val considerSpaces: Boolean = false,
        private val considerNewLine: Boolean = false
) : BaseMixedSectionStatic<String>(*sections) {
    override fun test(items: ItemsStatic.Class<String>): Boolean {
        return if (items is TokensStatic.Class) {
            items.saveState

            items.updateStates(
                    considerSpaces,
                    considerNewLine,
                    considerSeparations
            )

            val test = super.test(items)

            if (System.DEBUG) println("MixOrder = $test \t token =  ${items.token}  \t token.value = ${items.token?.value}")

            if (System.DEBUG_POSITIVES && test) println("PassiveSection Returns $test \t token =  ${items.token}  \t token.value = ${items.token?.value}")

            items.restoreState

            test
        } else false
    }
}