package unify.ast

import lib.cli.CLIArgumentsClass
import unify.tokens.characters.Colon
import language.ast.TokensClass as LangTokens
import language.ast.TokensStatic as LangTokensStatic


class TokensStatic : LangTokensStatic() {
    operator fun invoke(args: CLIArgumentsClass): TokensClass = TokensClass(args)

    override val tokenClasses = arrayOf(
            arrayOf(Colon)
    )

}

class TokensClass(args: CLIArgumentsClass) : LangTokens() {
    override val self = Tokens
    // mainFileName
    override val fileName = args["-fileName"]

    override val fileEncoding = args["-fileEncoding"]


}

val Tokens = TokensStatic()