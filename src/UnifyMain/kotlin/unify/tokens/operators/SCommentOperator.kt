package unify.tokens.operators

import unify.tokens.tokens.OperatorClass
import unify.tokens.tokens.OperatorStatic


class SCommentOperatorStatic : OperatorStatic() {

    override var tokenString: String = "//"

    override fun invoke(tokenString: String, l: Int, col: Int): SCommentOperatorClass = SCommentOperatorClass(tokenString, l, col)
}

class SCommentOperatorClass(tokenString: String, l: Int, col: Int) : OperatorClass(tokenString, l, col) {
    override val self = SCommentOperator
}

val SCommentOperator = SCommentOperatorStatic()