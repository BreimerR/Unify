package unify.tokens.strings

import unify.tokens.tokens.StringTokenClass
import unify.tokens.tokens.StringTokenStatic

class KeywordStatic : StringTokenStatic() {

    var keywords: String = "(infix|prefix|class|abstract|closed|trait|interface|public|static|void|null|when|for|if|elif|aka|else|get|set|switch|while|new|return|throw|import|do|TODO|todo)"

    override var regex = Regex("([a-zA-Z][a-zA-Z0-9_]*|_+[a-zA-Z0-9_]*)")

    override fun invoke(tokenString: String, l: Int, col: Int): KeywordClass = KeywordClass(tokenString, l, col)
}


class KeywordClass(tokenString: String, l: Int, col: Int) : StringTokenClass(tokenString, l, col) {
    override val self = Keyword
}


val Keyword = KeywordStatic()