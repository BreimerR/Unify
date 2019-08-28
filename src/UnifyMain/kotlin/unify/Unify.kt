package unify

import language.LanguageStatic
import language.sections.Section
import lib.cli.CLIArguments
import lib.cli.CLIArgumentsClass
import lib.matcher.TestableStatic
import unify.ast.Tokens
import unify.ast.TokensStatic
import unify.tokens.strings.Identifier


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

class Function {
    val sections = Section(Identifier, Section())
}




