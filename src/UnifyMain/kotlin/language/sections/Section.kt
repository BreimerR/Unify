package language.sections

import DEBUG_NEGATIVES
import DEBUG_POSITIVES
import DEBUG_SECTIONS
import Log
import language.ast.TokensStatic
import lib.matcher.TestableStatic
import lib.matcher.items.ItemsStatic
import DEBUG as SYS_DEBUG


open class Section(
        vararg sections: TestableStatic<String>,
        val considerSeparation: Boolean = false,
        val considerNewLines: Boolean = false,
        val considerSpaces: Boolean = false,
        name: String? = null
) : lib.matcher.sections.SectionStatic<String>(*sections, name = name) {

    open val TAG get() = this::class.simpleName ?: "Section"

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
        } else false
    }


    open val DEBUG
        get() = SYS_DEBUG && DEBUG_SECTIONS

    open fun debug(items: TokensStatic.Class, test: Boolean) {
        if (DEBUG) {

            val string = "test = $test\ttoken = ${items.token}"

            if (DEBUG_POSITIVES && test) Log.d(TAG, string)
            if (DEBUG_NEGATIVES) Log.d(TAG, string)

        }
    }
}
