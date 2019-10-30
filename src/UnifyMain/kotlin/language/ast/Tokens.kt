package language.ast


import language.tokens.TokenStatic
import lib.matcher.items.ItemStatic
import lib.matcher.items.ItemsStatic
import unify.tokens.characters.NewLineStatic
import unify.tokens.characters.SpaceStatic
import unify.tokens.characters.TabStatic
import language.tokens.TokenStatic.Class as Token

abstract class TokensStatic<T : TokenStatic.Class> : ItemsStatic() {

    abstract val tokenClasses: Array<out TokenStatic>

    abstract class Class(override val self: TokensStatic<out Token>) : ItemsStatic.Class<String>() {

        override val items get() = tokens

        abstract val fileName: String

        abstract val fileEncoding: String

        abstract val tokens: Array<out Token>

        // TODO use this instead of consider spaces variable
        var considerSeparation = true

        // TODO integrate use of new lines
        var considerNewLine = false

        override val nextItem: ItemStatic.Class<String>?
            get() {
                val token = super.nextItem

                @Suppress("RecursivePropertyAccessor")

                return if (considerSeparation) {
                    token
                } else if (token != null && isSeparation(token)) {
                    nextItem
                } else token
            }

        private fun isNewLine(token: ItemStatic.Class<String>): Boolean {
            return token is NewLineStatic.Class
        }

        private fun isSpace(token: ItemStatic.Class<String>): Boolean = token is SpaceStatic.Class

        private fun isTab(token: ItemStatic.Class<String>): Boolean = token is TabStatic.Class

        private fun isSeparation(token: ItemStatic.Class<String>): Boolean = isSpace(token) || isTab(token) || isNewLine(token)

        abstract fun isNewLine(klass: TokenStatic): Boolean


        abstract fun isTab(klass: TokenStatic): Boolean
    }
}

