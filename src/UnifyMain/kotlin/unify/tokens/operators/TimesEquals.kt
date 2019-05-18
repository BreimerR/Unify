package unify.tokens.operators

import unify.tokens.tokens.OperatorClass
import unify.tokens.tokens.OperatorStatic

class TimesEqualsStatic : OperatorStatic() {

    override var tokenString: String = "*="

    override fun invoke(tokenString: String, l: Int, col: Int): TimesEqualsClass = TimesEqualsClass(tokenString, l, col)
}

class TimesEqualsClass(tokenString: String, l: Int, col: Int) : OperatorClass(tokenString, l, col) {
    override val self = TimesEquals
}

val TimesEquals = TimesEqualsStatic()
