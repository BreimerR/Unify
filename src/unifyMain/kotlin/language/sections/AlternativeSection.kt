package language.sections

import language.ast.TokensStatic
import lib.matcher.TestableStatic
import lib.matcher.items.ItemsStatic
import unify.Unify
import lib.matcher.sections.AlternativeSectionStatic as BaseAlternativeSectionStatic

open class AlternativeSection(
        vararg sections: TestableStatic<String>,
        private val considerSeparation: Boolean = false,
        private val considerSpaces: Boolean = false,
        private val considerNewLine: Boolean = false,
        public override val name: String? = null
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

    override val TAG get() = (this::class.simpleName ?: "AlternativeSection") + if (name != null) "($name)" else ""

    open fun debug(items: TokensStatic.Class, test: Boolean) {
        Unify.debug(TAG, items, test)
    }
}