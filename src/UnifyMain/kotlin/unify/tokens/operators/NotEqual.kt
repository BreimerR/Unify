package unify.tokens.operators


import unify.tokens.tokens.OperatorClass
import unify.tokens.tokens.OperatorStatic

class NotEqualStatic : OperatorStatic() {
    override val tokenString = "!="

    override fun invoke(tokenString: String, l: Int, col: Int): NotEqualClass = NotEqualClass(tokenString, l, col)
}

class NotEqualClass(tokenString: String, l: Int, col: Int) : OperatorClass(tokenString, l, col) {
    override val self = NotEqual
}

val NotEqual = NotEqualStatic()
