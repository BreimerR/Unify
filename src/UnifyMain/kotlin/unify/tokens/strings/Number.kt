package unify.tokens.strings

import unify.tokens.tokens.StringTokenClass
import unify.tokens.tokens.StringTokenStatic

class NumberStatic : StringTokenStatic() {

    override var regex = Regex("[0-9][0-9]*")

    override fun invoke(tokenString: String, l: Int, col: Int): NumberClass = NumberClass(tokenString, l, col)
}

class NumberClass(tokenString: String, l: Int, col: Int) : StringTokenClass(tokenString, l, col) {
    override val self = Number
}

val Number = NumberStatic()