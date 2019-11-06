package unify.parsers.expressions

import language.parsers.ParserStatic
import language.sections.*
import unify.parsers.literals.ReferenceParser
import unify.tokens.characters.*

class PreFixExpressionParser : ParserStatic(
        PassiveSection(
                NotSection(
                        AlternativeSection(
                                FunctionStartParser(),
                                AssignmentExpressionParser()
                        )
                )
        ),
        ReferenceParser(),
        UnTerminatedExpressionParser(),
        // prefix expression end
        AlternativeSection(
                SColon,
                RBrace,
                Section(
                        ZeroOrMany(
                                AlternativeSection(
                                        Tab,
                                        Space
                                )
                        ),
                        NewLine,
                        considerSeparation = true
                )
        )

)