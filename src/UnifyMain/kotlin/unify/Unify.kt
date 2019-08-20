package unify


import language.LanguageClass
import language.LanguageStatic
import lib.cli.CLIArguments
import lib.cli.CLIArgumentsClass
import unify.ast.Statements
import unify.ast.Tokens

class UnifyStatic : LanguageStatic() {
    operator fun invoke(args: CLIArgumentsClass): Class = Class(args)

    class Class(args: CLIArgumentsClass) : LanguageClass() {
        // Tokenize
        override val tokens = Tokens(args["-fileName"], args["-fileEncoding"])

        override val self = Unify

    }
}


val Unify = UnifyStatic()

fun main(arguments: Array<String>) {
    val unify = Unify(CLIArguments(arguments))
}

