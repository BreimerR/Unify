package unify.sections

import unify.ast.TokensStatic
import lib.matcher.TestableStatic


open class Section(vararg val sections: TestableStatic) : TestableStatic() {

    var sI = 0

    var eI: Int? = null

    override fun test(items: TokensStatic.Class): Boolean {

        val i = items.i

        for (section in sections) {
            sI = items.i
            if (section.test(items)) {
                if (section is Section) {

                    val t = if (section is OptionalSection) section.test else true

                } else false

            } else return false
        }

        // collect(items, i, name)

        return true
    }

    private fun collect(start: Int, end: Int, name: String? = null) {

    }


}