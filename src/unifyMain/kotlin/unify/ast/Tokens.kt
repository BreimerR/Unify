package unify.ast


import language.lib.io.File
import lib.io.string
import unify.tokens.characters.*
import unify.tokens.strings.Character
import unify.tokens.strings.Identifier
import unify.tokens.strings.Keyword
import unify.tokens.strings.Number
import unify.tokens.tokens.EOF
import unify.tokens.tokens.OperatorStatic
import unify.tokens.tokens.TokenStatic
import unify.tokens.tokens.printLn
import language.ast.TokensStatic as LangTokensStatic
import language.ast.TokensStatic.Class as LangTokens


class TokensStatic : LangTokensStatic<TokenStatic.Class>() {
    val tabSize = 4

    operator fun invoke(fileName: String, fileEncoding: String = "utf-8"): Class = Class(fileName, fileEncoding)

    val stringTokens by lazy {
        arrayOf(
                Keyword,
                Character,
                Identifier,
                Number
        )
    }
    val characters by lazy {
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
    }

    override val tokenClasses by lazy {
        arrayOf(
                *stringTokens,
                *characters
        )
    }


    class Class(override val fileName: String, override val fileEncoding: String) : LangTokens(Tokens) {

        override val self: TokensStatic = Tokens

        override val items: MutableList<out language.tokens.TokenStatic.Class> by lazy {
            var field = mutableListOf<language.tokens.TokenStatic.Class>()

            var col = 1
            var line = 1

            File.open(fileName) {

                val items = Characters(chars)

                var i = 0

                fWhile@ while (items.hasRemItems) {

                    var tk: language.tokens.TokenStatic.Class? = null


                    fLoop@ for (clazz in this@Class.self.tokenClasses) {
                        @Suppress("SENSELESS_COMPARISON")
                        if (clazz != null) {
                            if (clazz test items) {

                                val s = items[i..items.nextIndex].toTypedArray().string
                                tk = clazz(s, line, col)
                                i = items.nextIndex
                                field += tk
                                when {
                                    isNewLine(clazz) -> {
                                        col = 1
                                        line += 1
                                    }
                                    isTab(clazz) -> {
                                        col += this@Class.self.tabSize - 1
                                    }
                                    else -> col += s.length
                                }

                                break@fLoop
                            } else items.nextIndex = i
                        } else throw Error("Malformed token class")
                    }

                    if (tk == null) throw Error("NO token found")
                }
            }

            field
        }

        override fun isTab(klass: language.tokens.TokenStatic): Boolean = klass is TabStatic

        override fun isNewLine(klass: language.tokens.TokenStatic): Boolean = klass is NewLineStatic

    }

}

val Tokens = TokensStatic()
