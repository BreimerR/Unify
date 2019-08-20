package unify.ast


import language.lib.io.File
import lib.collections.array.length
import lib.io.string
import lib.matcher.items.ItemStatic
import lib.matcher.items.ItemsStatic
import platform.posix.SEEK_CUR
import platform.posix.fileno
import unify.tokens.strings.*
import unify.tokens.operators.*
import unify.tokens.characters.*
import unify.tokens.tokens.*
import language.ast.TokensStatic.Class as LangTokens
import language.ast.TokensStatic as LangTokensStatic


class TokensStatic : LangTokensStatic<TokenStatic.Class>() {
    val tabSize = 4

    operator fun invoke(fileName: String, fileEncoding: String): Class = Class(fileName, fileEncoding)

    override val tokenClasses
        get() = arrayOf(
                * arrayOf(
                        DColon,
                        DoOperator,
                        ElvisOperator,
                        MinusEquals,
                        MlCommentEndOperator,
                        MLCommentOperator,
                        NotEqual,
                        PlusEquals,
                        ReturnOperator,
                        SCommentOperator,
                        TimesEquals
                ),
                *arrayOf(
                        Keyword,
                        Identifier,
                        Number
                ),
                * arrayOf(
                        Ampersand,
                        Asterisk,
                        At,
                        BSlash,
                        BTick,
                        Colon,
                        Coma,
                        Dollar,
                        Dot,
                        DQuotes,
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
                        SQuotes,
                        Tab,
                        UCaret,
                        Underscore
                )
        )

    class Class(override val fileName: String, override val fileEncoding: String) : LangTokens(Tokens) {
        override val tokens: Array<out language.tokens.TokenStatic.Class> by lazy {
            var field = arrayOf<language.tokens.TokenStatic.Class>()

            var col = 1
            var line = 1

            File.open(fileName) {
                val items = Characters(chars)

                var i = 0

                while (items.hasRemItems) {
                    var tk: language.tokens.TokenStatic.Class? = null

                    fLoop@ for (clazz in this@Class.self.tokenClasses) {
                        if (clazz test items) {
                            val s = items[i..items.i].toTypedArray().string
                            tk = clazz(s, line, col)
                            i = items.i
                            field += tk
                            when {
                                isNewLine(clazz) -> {
                                    col = 1
                                    line += 1
                                }
                                isTab(clazz) -> {
                                    col += 3
                                }
                                else -> col += s.length
                            }

                            break@fLoop
                        } else items.i = i
                    }

                    if (tk == null) throw Error("NO token found")
                }
            }


            field
        }


        override fun isTab(klass: language.tokens.TokenStatic): Boolean = klass is TabStatic

        override fun isNewLine(klass: language.tokens.TokenStatic): Boolean = klass is NewLineStatic

        init {
            for (token in tokens) {
                printLn(token, token.value)
            }
        }

        fun collect(items: ItemsStatic.Class<Char>, start: Int, end: Int) = items[start..end].toTypedArray().string

    }

}

val Tokens = TokensStatic()