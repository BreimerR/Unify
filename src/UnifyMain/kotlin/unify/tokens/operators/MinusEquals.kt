package unify.tokens.operators

import unify.tokens.tokens.OperatorClass
import unify.tokens.tokens.OperatorStatic


class MinusEqualsStatic : OperatorStatic() {

    override var tokenString: String = "-="

    override fun invoke(tokenString: String, l: Int, col: Int): MinusEqualsClass = MinusEqualsClass(tokenString, l, col)
}


class MinusEqualsClass(tokenString: String, l: Int, col: Int) : OperatorClass(tokenString, l, col) {
    override val self = MinusEquals
}

val MinusEquals = MinusEqualsStatic()