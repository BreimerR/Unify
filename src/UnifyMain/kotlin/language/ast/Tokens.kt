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

        // space tab or newLine
        var considerSeparation = true

        var considerSpaces = false

        // TODO integrate use of new lines
        var considerNewLine = false

        val token: TokenStatic.Class?
            get() = currentItem as TokenStatic.Class?

        val nextToken: ItemStatic.Class<String>?
            get() {
                val cToken = super.nextItem


                @Suppress("RecursivePropertyAccessor")
                return when {
                    cToken == null -> null
                    // skip newLIne
                    considerSpaces -> {
                        if (isNewLine(cToken))
                            nextToken
                        else
                            cToken
                    }

                    considerNewLine -> {
                        if (isTabSpace(cToken))
                            nextToken
                        else
                            cToken
                    }

                    // skip nothing
                    considerSeparation -> cToken

                    // skip NewLine Tab or Space
                    isSeparation(cToken) -> nextToken

                    else -> cToken
                }
            }

        private fun isNewLine(token: ItemStatic.Class<String>): Boolean {
            return token is NewLineStatic.Class
        }

        private fun isTabSpace(token: ItemStatic.Class<String>) = isTab(token) || isSpace(token)

        private fun isSpace(token: ItemStatic.Class<String>): Boolean = token is SpaceStatic.Class

        private fun isTab(token: ItemStatic.Class<String>): Boolean = token is TabStatic.Class

        private fun isSeparation(token: ItemStatic.Class<String>): Boolean = isSpace(token) || isTab(token) || isNewLine(token)

        abstract fun isNewLine(klass: TokenStatic): Boolean

        abstract fun isTab(klass: TokenStatic): Boolean

        var stateHolder: StateHolder = StateHolder(considerSeparation, considerSpaces, considerNewLine)

        val saveState: Unit
            get() {
                stateHolder = StateHolder(considerSeparation, considerSpaces, considerNewLine)
            }

        var savedIndex = i

        val pauseIndex: Unit
            get() {
                savedIndex = i
            }

        val resumeIndex: Unit
            get() {
                i = savedIndex
            }


        fun updateStates(considerSpaces: Boolean, considerNewLine: Boolean, considerSeparation: Boolean) {
            this.considerSpaces = considerSpaces
            this.considerNewLine = considerNewLine
            this.considerSeparation = considerSeparation
        }

        val restoreState: Unit
            get() {
                considerSeparation = stateHolder.considerSeparation
                considerNewLine = stateHolder.considerNewLine
                considerSpaces = stateHolder.considerSpaces
            }

        data class StateHolder(val considerSeparation: Boolean, val considerSpaces: Boolean, val considerNewLine: Boolean)

    }
}

