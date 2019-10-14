package unify.parsers

import language.parsers.Parser
import lib.matcher.sections.AlternativeSection
import lib.matcher.sections.Section
import unify.parsers.operators.DoOperatorParser
import unify.parsers.operators.ReturnOperatorParser
import unify.tokens.characters.LCBracket
import unify.tokens.characters.RCBracket
import unify.tokens.strings.Identifier

class FunctionBodyParser : Parser(
        AlternativeSection(
                // normal function
                Section(
                        LCBracket,
                        RCBracket
                ),
                // function returning the next thing available
                // function doing something and not returning anything
                Section(
                        AlternativeSection(
                                ReturnOperatorParser(),
                                DoOperatorParser()
                        ),
                        Identifier
                )
        )
) {
    override val considerSpaces = false
}