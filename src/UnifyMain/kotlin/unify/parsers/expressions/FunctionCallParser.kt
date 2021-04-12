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
    AlternativeSection(
        CallParser(),
        InfixFunctionCallParser()
    )
)

