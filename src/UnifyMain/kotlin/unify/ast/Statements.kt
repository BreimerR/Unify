package unify.ast

import language.ast.StatementsClass as LStatementsClass
import language.ast.StatementsStatic as LStatementsStatic

class StatementsStatic : LStatementsStatic() {
    operator fun invoke(): StatementsClass = StatementsClass()
}


class StatementsClass : LStatementsClass() {
    override val self = Statements


}

val Statements = StatementsStatic()