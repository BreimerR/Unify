package unify.tokens.operators

import unify.tokens.tokens.OperatorClass
import unify.tokens.tokens.OperatorStatic

class DoOperatorStatic : OperatorStatic() {
    override fun invoke(tokenString: String, l: Int, col: Int): DoOperatorClass = DoOperatorClass(tokenString, l, col)

    override var tokenString: String = "->"

}

class DoOperatorClass(tokenString: String, l: Int, col: Int) : OperatorClass(tokenString, l, col) {
    override val self = DoOperator
}

val DoOperator = DoOperatorStatic()