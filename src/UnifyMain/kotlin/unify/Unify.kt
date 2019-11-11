package unify

import language.LanguageStatic
import language.scopes.FileScope
import language.scopes.Scope
import language.sections.AlternativeSection
import language.sections.OptionalSection
import language.sections.ZeroOrMany
import lib.cli.CLIArguments
import lib.cli.CLIArgumentsClass
import unify.ast.Tokens
import unify.parsers.EOFParser
import unify.parsers.variables.TVariableDeclarationParser
import unify.parsers.comments.CommentsParser
import unify.parsers.expressions.TAssignmentExpressionParser
import unify.parsers.functions.FunctionParser
import unify.parsers.headers.ImportsParser
import unify.parsers.headers.PackageDefParser
import unify.parsers.objects.ClassParser
import unify.parsers.objects.EnumParser
import unify.parsers.objects.InterfaceParser


class Unify(args: CLIArgumentsClass) : LanguageStatic(
        OptionalSection(
                PackageDefParser()
        ),
        ImportsParser(),
        ZeroOrMany(
                AlternativeSection(
                        InterfaceParser(),
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
    // initialize arguments in a convenient readable mode
    val cli = CLIArguments(args)

    val unify = Unify(cli)

    println(unify.test())
}