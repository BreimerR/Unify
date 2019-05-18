package unify.tokens.operators


import unify.tokens.tokens.OperatorClass
import unify.tokens.tokens.OperatorStatic


class ReturnOperatorStatic : OperatorStatic() {

    override var tokenString: String = "=>"


    override fun invoke(tokenString: String, l: Int, col: Int): ReturnOperatorClass = ReturnOperatorClass(tokenString, l, col)
}


class ReturnOperatorClass(tokenString: String, l: Int, col: Int) : OperatorClass(tokenString, l, col) {
    override val self = ReturnOperator
}

val ReturnOperator = ReturnOperatorStatic()
