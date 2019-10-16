package unify.parsers

import language.parsers.Parser
import language.sections.AlternativeSection
import language.sections.OneOrManySection
import language.sections.Section
import unify.parsers.comments.CommentsParser
import unify.parsers.operators.DoOperatorParser
import unify.parsers.operators.ReturnOperatorParser
import unify.parsers.statements.FunctionParser
import unify.tokens.characters.LCBracket
import unify.tokens.characters.RCBracket
import unify.tokens.strings.Identifier


// TODO parser dead lock over-loops and does not recognize sections
class FunctionBodyParser : Parser(name = "FUNCTION_BODY") {
    override val sections by lazy {
        addStartSpaces(
                arrayOf(
                        AlternativeSection(
                                // normal function
                                AlternativeSection(
                                        Section(
                                                LCBracket,
                                                OneOrManySection(
                                                        AlternativeSection(
                                                                FunctionParser()
                                                        ),
                                                        considerSpaces = false
                                                ),
                                                RCBracket
                                        ),
                                        Section(
                                                LCBracket,
                                                RCBracket
                                        )
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
                )
        )
    }
}
