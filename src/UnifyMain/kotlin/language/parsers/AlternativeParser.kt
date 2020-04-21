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
    override val TAG = "AlternativeParser"

    override fun test(items: ItemsStatic.Class<String>): Boolean {
        val test = super.test(items)


        debug(items, test)

        return test
    }

    override fun debug(items: ItemsStatic.Class<String>, test: Boolean) {

        items as TokensStatic.Class

        if (DEBUG && DEBUG_PARSERS) {
            val token = items.token

            val line = token?.line
            val col = token?.col

            if (DEBUG_POSITIVES && test) Log.d(TAG, "test = $test\ttoken = $token[$line,$col]")
            if (DEBUG_NEGATIVES && !test) Log.d(TAG, "test = $test\ttoken = $token[$line,$col]")

        }
    }
}