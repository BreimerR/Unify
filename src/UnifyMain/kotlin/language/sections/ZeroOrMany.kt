package language.sections

import DEBUG_NEGATIVES
import DEBUG as SYS_DEBUG
import DEBUG_POSITIVES
import DEBUG_POSITIVE_PARSERS
import DEBUG_SECTIONS
import Log
import System
import language.ast.TokensStatic
import lib.matcher.TestableStatic
import lib.matcher.items.ItemsStatic
import lib.matcher.sections.ZeroOrManyStatic as BaseZeroOrManyStatic

open class ZeroOrMany(
        vararg sections: TestableStatic<String>,
        private var considerSeparation: Boolean = false,
        private var considerNewLine: Boolean = false,
        private var considerSpaces: Boolean = false
) : BaseZeroOrManyStatic<String>(*sections) {

    private val TAG: String = "ZeroMany"

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

            debug(items, test)

            test

        } else false
    }

    val DEBUG
        get() = SYS_DEBUG && DEBUG_SECTIONS

    open fun debug(items: TokensStatic.Class, test: Boolean) {
        if (DEBUG) {

            if (DEBUG_POSITIVES && test) Log.d(TAG, "test = $test\ttoken = ${items.token}\ttoken.value = ${items.token}")
            if (DEBUG_NEGATIVES) Log.d(TAG, "test = $test\ttoken = ${items.token}\ttoken.value = ${items.token}")

            if (DEBUG_POSITIVE_PARSERS && test) Log.d(TAG, "test = $test\ttoken = ${items.token}\ttoken.value = ${items.token}")

        }
    }

    operator fun invoke(
            vararg sections: TestableStatic<String>,
            considerSeparation: Boolean = false,
            considerNewLine: Boolean = false,
            considerSpaces: Boolean = false): ZeroOrMany {

        this.sections = sections
        this.considerNewLine = considerNewLine
        this.considerSeparation = considerSeparation
        this.considerSpaces = considerSpaces

        return this
    }
}
