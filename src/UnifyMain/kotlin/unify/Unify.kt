package unify

import DEBUG_SHOW_TOKENS
import Log
import System
import language.Language
import language.scopes.FileScope
import language.scopes.Scope
import language.sections.AlternativeSection
import language.sections.OptionalSection
import language.sections.ZeroOrMany
import lib.cli.CLIArguments
import unify.ast.Tokens
import unify.parsers.EOFParser
import unify.parsers.comments.CommentsParser
import unify.parsers.expressions.TAssignmentExpressionParser
import unify.parsers.functions.FunctionParser
import unify.parsers.headers.ImportsParser
import unify.parsers.headers.PackageDefParser
import unify.parsers.objects.ClassParser
import unify.parsers.objects.EnumParser
import unify.parsers.objects.InterfaceParser
import unify.parsers.variables.MultiVariableDeclarationParser
import unify.parsers.variables.TVariableDeclarationParser
import lib.cli.CLIArgumentsStatic.Class as CLIArgumentsClass


class Unify(args: CLIArgumentsClass) : Language(
        OptionalSection(
                PackageDefParser()
        ),
        ImportsParser(),
        ZeroOrMany(
                AlternativeSection(
                        InterfaceParser(),
                        MultiVariableDeclarationParser(),
                        TVariableDeclarationParser(),
                        TAssignmentExpressionParser(),
                        EnumParser(),
                        ClassParser(),
                        CommentsParser(),
                        FunctionParser()
                )
        ),
        EOFParser()
) {
    override val scope: Scope = FileScope()
    // found items parser
    override val tokens = Tokens(args["-fileName"], args["-fileEncoding"])

}

fun main(args: Array<String>) {
    // initialize arguments
    val cli = CLIArguments(args)

    val unify = Unify(cli)

    System.updateDebug(cli)


    if (DEBUG_SHOW_TOKENS) for (token in unify.tokens.tokens) println(token)

    Log.d("Unify.main", unify.test())

}