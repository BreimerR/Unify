package unify.sections

import lib.matcher.TestableStatic
import unify.ast.TokensStatic

class OptionalSection(vararg sections: TestableStatic) : Section(*sections) {

    var test = false

    override fun test(items: TokensStatic.Class): Boolean {
        val i = items.i

        test = super.test(items)

        // restore index if test fails
        if (!test) items.i = i

        return true
    }
}