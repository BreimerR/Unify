package language.sections

import DEBUG_NEGATIVES
import DEBUG  as SYS_DEBUG
import DEBUG_POSITIVES
import DEBUG_POSITIVE_PARSERS
import DEBUG_SECTIONS
import Log
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

            debug(items, test)
            test
        } else true
    }

    val TAG = "NotSection"

    val DEBUG get() = SYS_DEBUG && DEBUG_SECTIONS

    open fun debug(items: TokensStatic.Class, test: Boolean) {
        if (DEBUG) {

            if (DEBUG_POSITIVES && test) Log.d(TAG, "test =  $test \t token =  ${items.token}  \t token.value = ${items.token}")
            if (DEBUG_NEGATIVES) Log.d(TAG, "test = $test \t token =  ${items.token}  \t token.value = ${items.token}")

            if (DEBUG_POSITIVE_PARSERS && test) Log.d(TAG, "test = $test\ttoken = ${items.token}\ttoken.value = ${items.token}")

        }
    }
}