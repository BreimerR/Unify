package unify.tokens.strings

import unify.tokens.tokens.StringTokenClass
import unify.tokens.tokens.StringTokenStatic

class IdentifierStatic : StringTokenStatic() {
    override fun invoke(tokenString: String, l: Int, col: Int): IdentifierClass = IdentifierClass(tokenString, l, col)

    override val regex: Regex
        get() = TODO("not implemented") //To change initializer of created properties use File | Settings | File Templates.
}

class IdentifierClass(tokenString: String, l: Int, col: Int) : StringTokenClass(tokenString, l, col) {
    override val self = Identifier
}


val Identifier = IdentifierStatic()

