package language.sections

import DEBUG_NEGATIVES
import DEBUG as SYS_DEBUG
import DEBUG_POSITIVES
import DEBUG_POSITIVE_PARSERS
import DEBUG_SECTIONS
import Log
import language.ast.TokensStatic
import lib.matcher.TestableStatic
import lib.matcher.items.ItemsStatic
import unify.Unify
import lib.matcher.sections.RepetitiveSectionStatic as BaseRepetitiveSectionStatic


open class RepetitiveSection(
        vararg sections: TestableStatic<String>,
        val considerSeparation: Boolean = false,
        val considerNewLine: Boolean = false,
        val considerSpaces: Boolean = false,
        minCount: Int = 1,
        maxCount: Int = this.maxCount,
        name: String? = null
) : BaseRepetitiveSectionStatic<String>(*sections, minCount = minCount, maxCount = maxCount , name = name) {

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


            test
        } else false
    }

    val DEBUG get() = SYS_DEBUG && DEBUG_SECTIONS

    open fun debug(items: TokensStatic.Class, test: Boolean) {
        Unify.debug(TAG, items, test)
    }


}