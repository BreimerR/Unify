package language.ast


import language.tokens.TokenStatic
import lib.matcher.items.ItemsStatic
import language.tokens.TokenStatic.Class as Token

const val TAG = "TOKEN"

abstract class TokensStatic<T : TokenStatic.Class> : ItemsStatic() {

    abstract val tokenClasses: Array<out TokenStatic>

    abstract class Class(override val self: TokensStatic<out Token>) : ItemsStatic.Class<String>() {

        override val items get() = tokens

        abstract val fileName: String

        abstract val fileEncoding: String

        abstract val tokens: Array<out Token>

        abstract fun isNewLine(klass: TokenStatic): Boolean

        abstract fun isTab(klass: TokenStatic): Boolean
    }
}

