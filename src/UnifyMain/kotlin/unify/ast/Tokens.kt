package unify.ast

import unify.tokens.strings.*
import unify.tokens.operators.*
import unify.tokens.characters.*
import language.ast.TokensClass as LangTokens
import language.ast.TokensStatic as LangTokensStatic


class TokensStatic : LangTokensStatic() {
    operator fun invoke(fileName: String, fileEncoding: String): TokensClass = TokensClass(fileName, fileEncoding)

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

class TokensClass(override val fileName: String, override val fileEncoding: String) : LangTokens() {
    override val self = Tokens

}

val Tokens = TokensStatic()