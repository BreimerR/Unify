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
import lib.matcher.sections.MixedSectionStatic as BaseMixedSectionStatic

open class MixedOrderSection(
        vararg sections: TestableStatic<String>,
        private val considerSeparations: Boolean = false,
        private val considerSpaces: Boolean = false,
        private val considerNewLine: Boolean = false,
        name: String? = null
) : BaseMixedSectionStatic<String>(*sections,name = name) {

    override fun test(items: ItemsStatic.Class<String>): Boolean {
        return if (items is TokensStatic.Class) {
            items.saveState

            items.updateStates(
                    considerSpaces,
                    considerNewLine,
                    considerSeparations
            )

            val test = super.test(items)

            debug(items, test)

            items.restoreState

            test
        } else false
    }

    val DEBUG get() = SYS_DEBUG && DEBUG_SECTIONS

    open fun debug(items: TokensStatic.Class, test: Boolean) {
        Unify.debug(TAG, items, test)
    }
}