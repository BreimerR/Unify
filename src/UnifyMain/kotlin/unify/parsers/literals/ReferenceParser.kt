package unify.parsers.literals

import language.parsers.ParserStatic
import language.sections.AlternativeSection
import language.sections.ZeroOrMany
import lib.matcher.items.ItemsStatic
import unify.tokens.characters.Dot
import unify.tokens.strings.Identifier
import unify.tokens.strings.Keyword
import unify.tokens.strings.KeywordStatic


class ReferenceParser : ParserStatic(
        ZeroOrMany(
                AlternativeSection(
                        Identifier,
                        Keyword
                ),
                Dot
        ),
        AlternativeSection(
                Identifier
        )
) {


    var fileScope = false /*scope is FileScope*/

    private var error: String? = null

    override val TAG = "ReferenceParser"

    override fun test(items: ItemsStatic.Class<String>): Boolean {

        @Suppress("ConstantConditionIf")
        return if (fileScope) {
            if (KeywordStatic("this") test items) {
                error = ""
                false
            } else true
        }
        else super.test(items)
    }


    companion object {
        val age = 12
    }
}
