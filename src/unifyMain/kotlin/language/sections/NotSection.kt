package language.sections

import DEBUG_NEGATIVES
import DEBUG_POSITIVES
import DEBUG_POSITIVE_PARSERS
import DEBUG_SECTIONS
import Log
import language.ast.TokensStatic
import lib.matcher.TestableStatic
import lib.matcher.items.ItemsStatic
import unify.Unify
import DEBUG as SYS_DEBUG

open class NotSection(
        vararg sections: TestableStatic<String>,
        val considerSeparation: Boolean = false,
        val considerSpaces: Boolean = false,
        val considerNewLines: Boolean = false,
        name: String? = null
) : lib.matcher.sections.NotSectionStatic<String>(*sections, name = name) {

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

            debug(items, test)

            test

        } else true
    }


    val DEBUG get() = SYS_DEBUG && DEBUG_SECTIONS

    open fun debug(items: TokensStatic.Class, test: Boolean) {
        Unify.debug(TAG, items, test)
    }
}