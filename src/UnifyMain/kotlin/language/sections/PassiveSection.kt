package language.sections

import DEBUG_NEGATIVES
import DEBUG_POSITIVES
import DEBUG_POSITIVE_PARSERS
import DEBUG_SECTIONS
import Log
import language.ast.TokensStatic
import lib.matcher.TestableStatic
import lib.matcher.items.ItemsStatic
import lib.matcher.sections.SectionStatic
import unify.Unify
import DEBUG as SYS_DEBUG

open
class PassiveSection(
        vararg sections: TestableStatic<String>,
        val considerSeparation: Boolean = false,
        val considerNewLine: Boolean = false,
        val considerSpaces: Boolean = false,
        name: String? = null
) : SectionStatic<String>(*sections, name = name) {

    var test: Boolean = false

    override fun test(items: ItemsStatic.Class<String>): Boolean {
        return if (items is TokensStatic.Class) {

            items.pauseIndex

            items.saveState

            items.considerSeparation = considerSeparation

            items.updateStates(
                    considerSpaces,
                    considerNewLine,
                    considerSeparation
            )

            test = super.test(items)

            items.resumeIndex

            items.restoreState

            debug(items, test)

            test
        } else false
    }

    val DEBUG get() = SYS_DEBUG && DEBUG_SECTIONS

    open fun debug(items: TokensStatic.Class, test: Boolean) {
        Unify.debug(TAG, items, test)
    }
}