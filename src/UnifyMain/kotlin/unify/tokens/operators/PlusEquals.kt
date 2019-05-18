package unify.tokens.operators


import unify.tokens.tokens.OperatorClass
import unify.tokens.tokens.OperatorStatic


class PlusEqualsStatic : OperatorStatic() {

    override var tokenString: String = "+="

    override fun invoke(tokenString: String, l: Int, col: Int): PlusEqualsClass = PlusEqualsClass(tokenString, l, col)
}

class PlusEqualsClass(tokenString: String, l: Int, col: Int) : OperatorClass(tokenString, l, col) {
    override val self = PlusEquals
}

val PlusEquals = PlusEqualsStatic()
