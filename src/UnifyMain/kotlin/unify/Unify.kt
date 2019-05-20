package unify


import unify.ast.Tokens
import language.LanguageClass
import language.LanguageStatic
import lib.cli.CLIArguments
import lib.cli.CLIArgumentsClass
import unify.ast.Statements


class UnifyStatic : LanguageStatic() {
    operator fun invoke(args: CLIArgumentsClass): UnifyClass {
        return UnifyClass(args)
    }
}

class UnifyClass(args: CLIArgumentsClass) : LanguageClass() {
    // Tokenize
    override val tokens = Tokens(args["-fileName"], args["-fileEncoding"])

    override val self = Unify

    val statements = Statements(tokens)
}

val Unify = UnifyStatic()


fun main(arguments: Array<String>) {
    val unify = Unify(CLIArguments(arguments))


}
