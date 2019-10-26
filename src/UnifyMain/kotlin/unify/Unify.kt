package unify

import language.LanguageStatic
import language.ast.TokensStatic
import language.parsers.ParserStatic
import lib.cli.CLIArguments
import lib.cli.CLIArgumentsClass
import lib.cli.CLIArgumentsStatic
import lib.matcher.TestableStatic
import lib.matcher.sections.SectionStatic
import unify.ast.Tokens


class UnifyStatic : LanguageStatic() {

    private val parsers = arrayOf<ParserStatic>()

    operator fun invoke(vararg sections: TestableStatic<String>, name: String?): Class {
        return Class()
    }

    operator fun invoke(args: CLIArgumentsClass): Class {
        return Class(parsers, args)
    }

    class Class(args: CLIArgumentsClass) : LanguageStatic.Class() {

        override val self = Unify

        override val tokens = Tokens(args["-fileName"], args["-fileEncoding"])
    }
}


val Unify = UnifyStatic()

fun main(args: Array<String>) {
    // initialize arguments in a convenient readable mode
    val cli = CLIArguments(args)

    val unify = Unify(cli)

    while (unify.tokens.hasRemItems) {
        println(unify.tokens.nextItem)
    }

}