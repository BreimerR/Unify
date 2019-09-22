package unify.sections

import language.tokens.TokenStatic
import lib.matcher.TestableStatic
import unify.ast.TokensStatic


class NotSectionStatic(vararg sections: TestableStatic) : Section(*sections) {

    override fun test(items: TokensStatic.Class): Boolean {
        sections.forEach {
            if (it.test(items)) return false
        }

        return true
    }
}






