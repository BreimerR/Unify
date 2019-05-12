package unify.ast

import unify.tokens.characters.Colon
import unify.tokens.characters.SColon
import lib.cli.CLIArgumentsClass
import language.ast.TokensClass as LangTokens
import language.ast.TokensStatic as LangTokensStatic


class TokensStatic : LangTokensStatic() {
    operator fun invoke(args: CLIArgumentsClass): TokensClass = TokensClass(args)

    override val tokenClasses = arrayOf(
            arrayOf(Colon, SColon)
    )

}

class TokensClass(args: CLIArgumentsClass) : LangTokens() {
    override val self = Tokens
    // mainFileName
    override val fileName = args["-fileName"]

    override val fileEncoding = args["-fileEncoding"]


}

val Tokens = TokensStatic()