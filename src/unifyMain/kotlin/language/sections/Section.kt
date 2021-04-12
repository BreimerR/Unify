package language.sections

import DEBUG_SECTIONS
import Log
import language.ast.TokensStatic
import lib.matcher.TestableStatic
import lib.matcher.items.ItemsStatic
import lib.matcher.sections.SectionStatic
import unify.Unify
import DEBUG as SYS_DEBUG


open class Section(
    vararg sections: TestableStatic<String>,
    val considerSeparation: Boolean = false,
    val considerNewLines: Boolean = false,
    val considerSpaces: Boolean = false,
    name: String? = null,
) : SectionStatic<String>(*sections, name = name) {

    override fun test(items: ItemsStatic.Class<String>): Boolean {
        return if (items is TokensStatic.Class) {

            val test = doTest(items)

            debug(items, test)

            test
        } else false
    }

    fun doTest(items: TokensStatic.Class): Boolean {
        for (section in sections) {

            Log.d(TAG, "Start token = " + items.currentItem.toString())

            items.saveState

            items.updateStates(
                considerSpaces,
                considerNewLines,
                considerSeparation
            )

            val test = section test items


            items.restoreState

            Log.d(TAG, "End token = " + items.currentItem.toString())

            if (!test) return false
        }

        return sections.isNotEmpty()
    }

    open val DEBUG
        get() = SYS_DEBUG && DEBUG_SECTIONS

    open fun debug(items: TokensStatic.Class, test: Boolean) {
        Unify.debug(TAG, items, test)
    }
}

