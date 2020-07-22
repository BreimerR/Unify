package unify.parsers.expressions

import language.parsers.ParserStatic
import language.sections.*
import lib.matcher.TestableStatic
import unify.parsers.TerminatorParser
import unify.parsers.TypeDeclarationParser
import unify.parsers.literals.ReferenceParser
import unify.tokens.characters.Coma
import unify.tokens.characters.Dot
import unify.tokens.characters.LBracket
import unify.tokens.characters.RBracket
import unify.tokens.strings.Identifier

/**TODO
 * function call parser does not parse well
 * if followed by an expression it fails to parse
 * not sure causes of this yet
 * sample bad code
 * func main(){
 *     println(age,age,age)
 *     println(age,age)
 *     println()
 * }
 * sample working code
 * func main(){
 *      println()
 * }
 * func main (){
 *      println(age)
 * }
 * */
class FunctionCallParser : ParserStatic(
        AlternativeSection(
                ParameterFunctionCall(),
                InfixFunctionCallParser()
        )
) {

    class SimpleFunctionCallParser : ParserStatic(
            Identifier,
            LBracket,
            OptionalSection(
                    ExpressionParser(),
                    ZeroOrMany(
                            Coma,
                            ExpressionParser()
                    )
            ),
            RBracket
    )

    class ParameterFunctionCall : ParserStatic(
            SimpleFunctionCallParser()
    )

    class InfixFunctionCallParser : ParserStatic(
            ReferenceParser(),
            ReferenceParser(),
            // TODO this requires knowledge of the IR code
            // as you can not describe this symbolic and
            // come out with a reasonable
            // conclusion of what it should be
            AlternativeSection(
                    // this is a problem
                    // Alternative<Sleep>
                    // can be reference lessThan Sleep and > is left hanging
                    // parsing type declaration
                    // sleep > 10
                    // sleep is a TypeDeclaration and > 10 is left hanging
                    TypeDeclarationParser(),
                    ExpressionParser()
            )
    )

    class TFunctionCallParser : ParserStatic(
            AlternativeSection(
                    ParameterFunctionCall(),
                    InfixFunctionCallParser()
            ),
            TerminatorParser()
    )
}
