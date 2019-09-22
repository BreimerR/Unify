package unify

import language.LanguageStatic
import lib.cli.CLIArguments
import lib.cli.CLIArgumentsClass
import unify.ast.Tokens


class UnifyStatic : LanguageStatic() {

    operator fun invoke(args: CLIArgumentsClass): Class = Class(args)

    class Class(args: CLIArgumentsClass) : LanguageStatic.Class() {

        override val tokens = Tokens(args["-fileName"], args["-fileEncoding"])

        override val self = Unify

    }

}

val Unify = UnifyStatic()

fun main(arguments: Array<String>) {
    // tokens ready
    val unify = Unify(CLIArguments(arguments))


    // test instances against something

}


