package unify

import language.LanguageStatic
import lib.cli.CLIArguments
import lib.cli.CLIArgumentsClass
import unify.ast.Tokens
import lib.matcher.sections.*
import unify.tokens.characters.*
import unify.tokens.strings.Identifier
import unify.tokens.strings.KeywordStatic


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
    val un = Unify(CLIArguments(arguments))

    val type = Section(
            LThan,
            RepetitiveBySection(Coma, Identifier),
            GThan
    )

    val klass = Section(
            KeywordStatic("class"),
            OneOrManySection(Space),
            Identifier,
            OptionalSection(type)
    )

    println(klass.test(un.tokens))


}


