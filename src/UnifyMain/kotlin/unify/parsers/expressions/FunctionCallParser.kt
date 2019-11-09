package unify.parsers.expressions

import language.parsers.AlternativeParser
import language.sections.OptionalSection
import language.sections.RepetitiveBySection
import language.sections.Section
import unify.parsers.literals.ReferenceParser
import unify.tokens.characters.Coma
import unify.tokens.characters.LBracket
import unify.tokens.characters.RBracket
import unify.tokens.strings.Identifier

class FunctionCallParser : AlternativeParser(
        Section(
                ReferenceParser(),
                LBracket,
                OptionalSection(
                        RepetitiveBySection(
                                ExpressionParser(),
                                Coma
                        )
                ),
                RBracket
        ),
        Section(
                ReferenceParser(),
                Section(Identifier),
                ExpressionParser()
        )
)
