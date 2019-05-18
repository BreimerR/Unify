package unify.tokens.operators


import unify.tokens.tokens.OperatorClass
import unify.tokens.tokens.OperatorStatic


class ElvisOperatorStatic : OperatorStatic() {

    override var tokenString: String = "?:"


    override fun invoke(tokenString: String, l: Int, col: Int): ElvisOperatorClass = ElvisOperatorClass(tokenString, l, col)
}


class ElvisOperatorClass(tokenString: String, l: Int, col: Int) : OperatorClass(tokenString, l, col) {
    override val self = ElvisOperator

}

val ElvisOperator = ElvisOperatorStatic()