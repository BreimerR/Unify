package unify

import language.LanguageStatic
import language.parsers.Parser
import lib.cli.CLIArguments
import lib.cli.CLIArgumentsClass
import unify.ast.Tokens
import unify.parsers.EOFParser
import unify.parsers.FunctionParser
import unify.parsers.comments.MultiLineCommentParser
import unify.parsers.comments.SingleLineCommentParser
import unify.parsers.operators.SCommentOperatorParser


class UnifyStatic : LanguageStatic() {

    override val parsers by lazy {
        arrayOf(
                MultiLineCommentParser(),
                SingleLineCommentParser(),
                FunctionParser(),
                EOFParser()
        )
    }

    operator fun invoke(args: CLIArgumentsClass): Class = Class(args)

    class Class(args: CLIArgumentsClass) : LanguageStatic.Class() {

        override val tokens = Tokens(args["-fileName"], args["-fileEncoding"])

        override val self by lazy {
            Unify
        }

    }


}

val Unify = UnifyStatic()

fun main(arguments: Array<String>) {
    // tokens ready
    val un = Unify(CLIArguments(arguments))

    un.parse()

}