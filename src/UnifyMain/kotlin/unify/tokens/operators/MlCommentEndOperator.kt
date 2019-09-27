
package unify.tokens.operators

import unify.tokens.tokens.OperatorStatic


val MlCommentEndOperator = MlCommentEndOperatorStatic()


class MlCommentEndOperatorStatic : OperatorStatic() {

    override var tokenString: String = "*/"

    override fun invoke(tokenString: String, l: Int, col: Int): Class = Class(tokenString, l, col)

    class Class(tokenString: String, l: Int, col: Int) : OperatorStatic.Class(tokenString, l, col,MlCommentEndOperator) 
}
