package unify.tokens.operators

import unify.tokens.tokens.OperatorClass
import unify.tokens.tokens.OperatorStatic


class MLCommentOperatorStatic : OperatorStatic() {

    override var tokenString: String = "/*"

    override fun invoke(tokenString: String, l: Int, col: Int): MLCommentOperatorClass = MLCommentOperatorClass(tokenString, l, col)
}

class MLCommentOperatorClass(tokenString: String, l: Int, col: Int) : OperatorClass(tokenString, l, col) {
    override val self = MLCommentOperator
}

val MLCommentOperator = MLCommentOperatorStatic()