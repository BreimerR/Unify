
package unify.tokens.operators

import unify.tokens.tokens.OperatorStatic


val PlusEquals = PlusEqualsStatic()


class PlusEqualsStatic : OperatorStatic() {

    override var tokenString: String = "+="

    override fun invoke(tokenString: String, l: Int, col: Int): Class = Class(tokenString, l, col)

    class Class(tokenString: String, l: Int, col: Int) : OperatorStatic.Class(tokenString, l, col,PlusEquals) 
}
