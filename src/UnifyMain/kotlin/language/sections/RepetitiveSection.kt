package language.sections

import System
import language.ast.TokensStatic
import lib.matcher.TestableStatic
import lib.matcher.items.ItemsStatic
import lib.matcher.sections.RepetitiveSectionStatic as BaseRepetitiveSectionStatic


open class RepetitiveSection(
        vararg sections: TestableStatic<String>,
        val considerSeparation: Boolean = false,
        val considerNewLine: Boolean = false,
        val considerSpaces: Boolean = false,
        minCount: Int = 1,
        maxCount: Int = this.maxCount
) : BaseRepetitiveSectionStatic<String>(*sections, minCount = minCount, maxCount = maxCount) {

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

            if (System.DEBUG) println("RepetitiveSection = $test \t token =  ${items.token}  \t token.value = ${items.token?.value}")

            if (System.DEBUG_POSITIVES && test) println("PassiveSection Returns $test \t token =  ${items.token}  \t token.value = ${items.token?.value}")

            test
        } else false
    }
}