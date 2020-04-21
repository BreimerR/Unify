package unify.parsers.expressions

import language.parsers.ParserStatic
import language.sections.AlternativeSection
import unify.parsers.literals.LiteralParser
import unify.parsers.literals.ReferenceParser


/**@DESCRIPTION
 * reference expression
 * @Issues
 * this presentation does not play soo well with other properties i.e
 * reference reference1 reference2
 * the above presentation could either be
 * infix function with reference1 being the functionName
 * or two prefix functions with
 * reference being a functionName and reference1 being a functionName and reference2 being the parameter
 *
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