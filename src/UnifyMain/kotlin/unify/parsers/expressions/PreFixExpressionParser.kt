package unify.parsers.expressions

import language.parsers.ParserStatic
import language.sections.AlternativeSection
import unify.parsers.literals.LiteralParser
import unify.parsers.literals.ReferenceParser


/**TODO
 * implementation of this would require redefining of
 * expression parser to considerNewLines in some cases and in some not to consider them
 * */
class PreFixExpressionParser : ParserStatic(
        ReferenceParser(),
        AlternativeSection(
                LiteralParser(),
                ReferenceParser()
        )
) {
    override val TAG = "PrefixExpressionParser"
}