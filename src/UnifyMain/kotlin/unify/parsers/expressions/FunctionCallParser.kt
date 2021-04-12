package unify.parsers.expressions

import language.parsers.ParserStatic
import language.sections.*
import unify.parsers.functions.CallParser

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

