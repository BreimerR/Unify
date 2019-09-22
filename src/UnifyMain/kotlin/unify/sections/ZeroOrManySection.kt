package unify.sections

import unify.ast.TokensStatic


abstract class ZeroOrManySection : RepetitiveSection() {


    override fun test(items: TokensStatic.Class): Boolean {
        val i = items.i

        if (!super.test(items)) items.i = i

        return true
    }
}