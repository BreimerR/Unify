package language.parsers

import DEBUG
import DEBUG_NEGATIVES
import DEBUG_PARSERS
import DEBUG_POSITIVES
import Log
import language.ast.TokensStatic
import language.sections.AlternativeSection
import lib.matcher.TestableStatic
import lib.matcher.items.ItemsStatic


open class AlternativeParser(
        vararg sections: TestableStatic<String>,
        considerSeparation: Boolean = false,
        considerSpaces: Boolean = false,
        considerNewLine: Boolean = false
) : AlternativeSection(
        *sections,
        considerSeparation = considerSeparation,
        considerSpaces = considerSpaces,
        considerNewLine = considerNewLine
) {
    override fun test(items: ItemsStatic.Class<String>): Boolean {
        val test = super.test(items)


        debug(items, test)

        return test
    }

    override fun debug(items: ItemsStatic.Class<String>, test: Boolean) {

        items as TokensStatic.Class

        if (DEBUG && DEBUG_PARSERS) {

            if (DEBUG_POSITIVES && test) Log.d(TAG, "test = $test\ttoken = ${items.token}\ttoken.value = ${items.token}")
            if (DEBUG_NEGATIVES && !test) Log.d(TAG, "test = $test\ttoken = ${items.token}\ttoken.value = ${items.token}")

        }
    }
}