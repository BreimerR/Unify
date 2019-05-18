package unify.tokens.operators

import unify.tokens.tokens.OperatorClass
import unify.tokens.tokens.OperatorStatic


val DColon = DColonStatic()


class DColonStatic : OperatorStatic() {

    override var tokenString: String = "::"


    override fun invoke(tokenString: String, l: Int, col: Int): DColonClass = DColonClass(tokenString, l, col)
}


class DColonClass(tokenString: String, l: Int, col: Int) : OperatorClass(tokenString, l, col) {
    override val self = DColon
}