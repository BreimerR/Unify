package unify.parsers

import language.parsers.ParserStatic
import language.sections.AlternativeSection
import language.sections.OptionalSection
import language.sections.RepetitiveBySection
import language.sections.Section
import unify.parsers.expressions.ExpressionParser
import unify.parsers.literals.ReferenceParser
import unify.tokens.characters.Colon
import unify.tokens.characters.Coma
import unify.tokens.characters.Equals
import unify.tokens.strings.Identifier

class SimpleVariableParser : ParserStatic(
        AlternativeSection(
                Section(TypeInitializationParser(), Identifier),
                Section(Identifier)
        ),
        OptionalSection(
                Colon,
                ExpressionParser()
        ),
        OptionalSection(
                ReferenceOperatorParser(),
                RepetitiveBySection(
                        ReferenceParser(),
                        Coma,
                        maxCount = 1
                )
        ),
        OptionalSection(
                Equals,
                ExpressionParser()
        )
)