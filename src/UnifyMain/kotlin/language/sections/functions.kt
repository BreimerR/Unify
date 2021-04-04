package language.sections

import language.ast.TokensStatic
import lib.matcher.items.ItemsStatic
import lib.matcher.sections.SectionStatic

fun <T> doTest(items: ItemsStatic.Class<T>, obj: SectionStatic<T>): Boolean = with(obj) {
    for (section in sections) {

        Log.d(TAG, "Start token = " + items.currentItem.toString())

        val test = section test items

        Log.d(TAG, "End token = " + items.currentItem.toString())

        if (!test) return false
    }

    return sections.isNotEmpty()
}