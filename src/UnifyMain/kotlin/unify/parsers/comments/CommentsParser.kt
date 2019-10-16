package unify.parsers.comments

import language.parsers.Parser
import language.sections.OptionalSection
import language.sections.Section
import lib.matcher.items.ItemsStatic
import unify.tokens.strings.Identifier


class CommentsParser : Parser(
        Section(
                OptionalSection(
                        Identifier
                )
        )
) {
    override fun test(items: ItemsStatic.Class<String>): Boolean {

        println(super.test(items))
        return false
    }
}