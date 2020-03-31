package unify.parsers.variables

import language.parsers.ParserStatic
import language.sections.OptionalSection
import language.sections.RepetitiveBySection
import unify.parsers.ReferenceOperatorParser
import unify.parsers.expressions.ExpressionParser
import unify.parsers.literals.ReferenceParser
import unify.tokens.characters.Colon
import unify.tokens.characters.Coma
import unify.tokens.characters.Equals

class VariableEndParser : ParserStatic(
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
) {
    override val TAG = "VariableEndParser"
}