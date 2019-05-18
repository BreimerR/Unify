package unify.tokens.operators


import unify.tokens.tokens.OperatorClass
import unify.tokens.tokens.OperatorStatic

class MLCommentEndOperatorStatic : OperatorStatic() {

    override var tokenString: String = "*/"


    override fun invoke(tokenString: String, l: Int, col: Int): MLCommentEndOperatorClass = MLCommentEndOperatorClass(tokenString, l, col)
}

class MLCommentEndOperatorClass(tokenString: String, l: Int, col: Int) : OperatorClass(tokenString, l, col) {
    override val self = MLCommentEndOperator
}

val MLCommentEndOperator = MLCommentEndOperatorStatic()
