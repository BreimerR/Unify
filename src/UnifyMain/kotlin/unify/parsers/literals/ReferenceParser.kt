package unify.parsers.literals

import language.parsers.ParserStatic
import language.sections.RepetitiveBySection
import lib.matcher.items.ItemsStatic
import unify.tokens.characters.Dot
import unify.tokens.strings.Identifier
import unify.tokens.strings.KeywordStatic


class ReferenceParser : ParserStatic(
        RepetitiveBySection(
                Identifier,
                Dot
        )
) {
    private var error: String? = null

    override fun test(items: ItemsStatic.Class<String>): Boolean {
        val fileScope = false /*scope is FileScope*/

        @Suppress("ConstantConditionIf")
        return if (fileScope) {
            if (KeywordStatic("this") test items) {
                error = ""
                false
            } else true
        } else super.test(items)
    }
}
