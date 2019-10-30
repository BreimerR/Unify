package unify

import language.LanguageStatic
import lib.cli.CLIArguments
import lib.cli.CLIArgumentsClass
import unify.ast.Tokens
import unify.parsers.EOFParser
import unify.parsers.FunctionParser


class Unify(args: CLIArgumentsClass) : LanguageStatic(
        FunctionParser(),
        EOFParser()
) {

    override val tokens = Tokens(args["-fileName"], args["-fileEncoding"])

}

fun main(args: Array<String>) {
    // initialize arguments in a convenient readable mode
    val cli = CLIArguments(args)

    val unify = Unify(cli)

    println(unify.test())
}