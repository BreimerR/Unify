package unify

import language.LanguageStatic
import lib.cli.CLIArguments
import lib.cli.CLIArgumentsClass
import unify.ast.Tokens
import unify.parsers.EOFParser
import unify.parsers.comments.CommentsParser
import unify.parsers.statements.FunctionParser
import unify.parsers.comments.MultiLineCommentParser
import unify.parsers.comments.SingleLineCommentParser


class UnifyStatic : LanguageStatic() {

    override val parsers by lazy {
        arrayOf(
                CommentsParser(),
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