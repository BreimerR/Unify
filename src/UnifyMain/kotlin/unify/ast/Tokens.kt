package unify.ast

import lib.cli.CLIArgumentsClass
import unify.tokens.characters.*
import unify.tokens.operators.*
import unify.tokens.strings.*
import language.ast.TokensClass as LangTokens
import language.ast.TokensStatic as LangTokensStatic


class TokensStatic : LangTokensStatic() {
    operator fun invoke(args: CLIArgumentsClass): TokensClass = TokensClass(args)

    override val tokenClasses = arrayOf(
            arrayOf(
                    DColon,
                    DoOperator,
                    ElvisOperator,
                    MinusEquals,
                    MLCommentEndOperator,
                    MLCommentOperator,
                    NotEqual,
                    PlusEquals,
                    ReturnOperator,
                    SCommentOperator,
                    TimesEquals
            ),
            arrayOf(
                    Keyword,
                    Number
            ),
            arrayOf(
                    Ampersand,
                    Asterisk,
                    At,
                    BSlash,
                    BTick,
                    Colon,
                    Coma,
                    Dollar,
                    Dot,
                    DQuotation,
                    EOF,
                    Equals,
                    EscapedR,
                    Exclamation,
                    FSlash,
                    GThan,
                    Hash,
                    LBrace,
                    LBracket,
                    LSBracket,
                    LThan,
                    Minus,
                    NewLine,
                    Percent,
                    Pipe,
                    Plus,
                    Question,
                    RBracket,
                    RBrace,
                    RSBracket,
                    SColon,
                    SLine,
                    Space,
                    SQuotation,
                    Tab,
                    UCaret,
                    Underscore
            )
    )

}

class TokensClass(args: CLIArgumentsClass) : LangTokens() {
    override val self = Tokens
    // mainFileName
    override val fileName = args["-fileName"]

    override val fileEncoding = args["-fileEncoding"]


}

val Tokens = TokensStatic()