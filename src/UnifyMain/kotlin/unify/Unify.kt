package unify


import unify.ast.Tokens
import language.LanguageClass
import language.LanguageStatic
import lib.cli.CLIArguments
import lib.cli.CLIArgumentsClass


class UnifyStatic : LanguageStatic() {
    operator fun invoke(args: CLIArgumentsClass): UnifyClass {
        return UnifyClass(args)
    }
}

class UnifyClass(args: CLIArgumentsClass) : LanguageClass() {
    override val tokens = Tokens(args)

    override val self = Unify
}

val Unify = UnifyStatic()


fun main(arguments: Array<String>) {
    val unify = Unify(CLIArguments(arguments))


}
