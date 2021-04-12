package language.sections

import DEBUG_SECTIONS
import Log
import language.ast.TokensStatic
import lib.matcher.TestableStatic
import lib.matcher.items.ItemsStatic
import unify.Unify
import DEBUG as SYS_DEBUG
import lib.matcher.sections.OptionalSectionStatic as BaseOptionalSectionStatic


class OptionalSection(
        vararg sections: TestableStatic<String>,
        private val considerSeparation: Boolean = false,
        private val considerSpaces: Boolean = false,
        private val considerNewLines: Boolean = false,
        name: String? = null
) : BaseOptionalSectionStatic<String>(*sections, name = name) {

    override val TAG get() = (this::class.simpleName ?: "OptionalSection") + if (name != null) "($name)" else ""

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
        Unify.debug(TAG, items, test)
    }
}

