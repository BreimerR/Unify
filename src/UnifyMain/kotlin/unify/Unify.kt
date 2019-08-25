package unify

import language.LanguageStatic
import lib.cli.CLIArguments
import lib.cli.CLIArgumentsClass
import lib.matcher.TestableStatic
import unify.ast.Tokens
import unify.ast.TokensStatic


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
}

fun parser(tokens: TokensStatic.Class, section: TestableStatic.Class<String>) {
    if (section parse tokens) {

    } else throw Error("Parse Error found")
}




