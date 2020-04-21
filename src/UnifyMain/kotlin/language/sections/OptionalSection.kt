package language.sections

import DEBUG_NEGATIVES
import DEBUG_POSITIVES
import DEBUG_POSITIVE_PARSERS
import DEBUG_SECTIONS
import Log
import language.ast.TokensStatic
import lib.matcher.TestableStatic
import lib.matcher.items.ItemsStatic
import DEBUG as SYS_DEBUG
import lib.matcher.sections.OptionalSectionStatic as BaseOptionalSectionStatic


class OptionalSection(
        vararg sections: TestableStatic<String>,
        private val considerSeparation: Boolean = false,
        private val considerSpaces: Boolean = false,
        private val considerNewLines: Boolean = false,
        name: String? = null
) : BaseOptionalSectionStatic<String>(*sections, name = name) {

    override val TAG = "OptionalSection"

    override fun test(items: ItemsStatic.Class<String>): Boolean {
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
        } else {

            Log.d(TAG, "This is the wrong class being passed error")

            false
        }
    }

    val DEBUG get() = SYS_DEBUG && DEBUG_SECTIONS

    fun debug(items: TokensStatic.Class, test: Boolean) {
        if (DEBUG) {

            val string = "test = $test\ttoken = ${items.token}"

            if (DEBUG_POSITIVES && test) Log.d(TAG, string)
            if (DEBUG_NEGATIVES) Log.d(TAG, string)

            if (DEBUG_POSITIVE_PARSERS && test) Log.d(TAG, string)

        }
    }
}

