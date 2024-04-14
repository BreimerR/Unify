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

    abstract class Class(override val self: TokensStatic<out Token>) : ItemsStatic.Class<String>(), Iterable<Token> {

        abstract val fileName: String

        abstract val fileEncoding: String


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

                    // skip nothing
                    considerSeparation -> cToken

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

                    // skip NewLine Tab or Space
                    isSeparation(cToken) -> nextToken

                    else -> cToken
                }
            }

        val peekPrevToken: ItemStatic.Class<String>?
            get() {
                val i = nextIndex
                goBack()
                val cToken = super.currentItem


                @Suppress("RecursivePropertyAccessor")
                val token = when {

                    cToken == null -> null

                    // skip nothing
                    considerSeparation -> cToken

                    // skip newLIne
                    considerSpaces -> {
                        if (isNewLine(cToken))
                            peekPrevToken
                        else
                            cToken
                    }

                    considerNewLine -> {
                        if (isTabSpace(cToken))
                            peekPrevToken
                        else
                            cToken
                    }

                    // skip NewLine Tab or Space
                    isSeparation(cToken) -> peekPrevToken

                    else -> cToken
                }

                nextIndex = i
                return token
            }

        val peekNextToken: ItemStatic.Class<String>?
            get() {
                val i = nextIndex
                val token = nextToken
                nextIndex = i
                return token
            }



        private fun isNewLine(token: ItemStatic.Class<String>): Boolean {
            return token is NewLineStatic.Class
        }

        private fun isTabSpace(token: ItemStatic.Class<String>) = isTab(token) || isSpace(token)

        private fun isSpace(token: ItemStatic.Class<String>): Boolean = token is SpaceStatic.Class

        private fun isTab(token: ItemStatic.Class<String>): Boolean = token is TabStatic.Class

        private fun isSeparation(token: ItemStatic.Class<String>): Boolean =
            isSpace(token) || isTab(token) || isNewLine(token)

        abstract fun isNewLine(klass: TokenStatic): Boolean

        abstract fun isTab(klass: TokenStatic): Boolean

        private var stateHolder: StateHolder = StateHolder(considerSeparation, considerSpaces, considerNewLine)

        val saveState: Unit
            get() {
                stateHolder = StateHolder(considerSeparation, considerSpaces, considerNewLine)
            }

        var savedIndex = nextIndex

        val pauseIndex: Unit
            get() {
                savedIndex = nextIndex
            }

        val resumeIndex: Unit
            get() {
                nextIndex = savedIndex
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

        internal data class StateHolder(
            val considerSeparation: Boolean,
            val considerSpaces: Boolean,
            val considerNewLine: Boolean,
        )

        override fun iterator(): Iterator<Token> {

            return object : Iterator<Token> {
                override fun hasNext(): Boolean = hasRemItems

                override fun next(): Token = nextItem as TokenStatic.Class

            }
        }

    }


}
