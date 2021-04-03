package unify.parsers.expressions

import language.parsers.ParserStatic
import language.sections.*
import lib.matcher.TestableStatic
import unify.parsers.ArgumentParser
import unify.parsers.TerminatorParser
import unify.parsers.TypeDeclarationParser
import unify.parsers.functions.CallParser
import unify.parsers.functions.ParametersParser
import unify.parsers.functions.SimpleParameterParser
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
        ReferenceParser(),
        LBracket,
        OptionalSection(
                Identifier,
                ZeroOrMany(
                        Coma,
                        Identifier
                ),
                name = "PARAMS"

        ),
        RBracket
) {

    class ParameterFunctionCall : ParserStatic() {
        override var sections: Array<out TestableStatic<String>>
            get() = arrayOf(
                    ReferenceParser(),
                    LBracket,
                    OptionalSection(
                            RepetitiveBySection(
                                    Identifier,
                                    Coma,
                                    considerNewLines = true
                            )
                    ),
                    RBracket
            )
            set(value) {}
    }

    class InfixFunctionCallParser : ParserStatic(
            ReferenceParser(),
            ReferenceParser(),
            // TODO this requires knowledge of the IR code
            // as you can not describe this symbolic and
            // come out with a reasonable
            // conclusion of what it should be
            AlternativeSection(
                    // TODO problem might have been solved***
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

class TFunctionCallParser : ParserStatic() {
    override var sections: Array<out TestableStatic<String>>
        get() = arrayOf(
                CallParser(),
                TerminatorParser()
        )
        set(value) {}
}