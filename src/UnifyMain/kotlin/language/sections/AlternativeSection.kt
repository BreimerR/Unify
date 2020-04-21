package language.sections

import DEBUG
import DEBUG_NEGATIVES
import DEBUG_POSITIVES
import DEBUG_SECTIONS
import Log
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

        items as TokensStatic.Class

        items.saveState

        items.updateStates(
                considerSpaces,
                considerNewLine,
                considerSeparation
        )

        val test = super.test(items)

        items.restoreState

        debug(items, test)

        return test

    }

    open val TAG = "AlternativeSection"

    open fun debug(items: ItemsStatic.Class<String>, test: Boolean) {

        if (DEBUG && DEBUG_SECTIONS) {

            items as TokensStatic.Class

            val string = "test = $test\ttoken = ${items.token}"

            if (DEBUG_POSITIVES && test) Log.d(TAG, string)
            if (DEBUG_NEGATIVES) Log.d(TAG, string)

        }
    }
}