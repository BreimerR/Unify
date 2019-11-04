package unify

import language.LanguageStatic
import lib.cli.CLIArguments
import lib.cli.CLIArgumentsClass
import unify.ast.Tokens
import unify.parsers.functions.FunctionParser
import unify.parsers.EOFParser
import unify.parsers.VariableDeclarationParser
import unify.parsers.comments.CommentsParser
import unify.parsers.expressions.ExpressionParser
import unify.parsers.objects.ClassParser
import unify.parsers.objects.EnumParser


class Unify(args: CLIArgumentsClass) : LanguageStatic(
        VariableDeclarationParser(),
        ExpressionParser(),
        EnumParser(),
        ClassParser(),
        CommentsParser(),
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