package unify.sections

import lib.matcher.TestableStatic
import unify.ast.TokensStatic

class AlternativeSection(vararg sections: TestableStatic) : Section(*sections) {


    override fun test(items: TokensStatic.Class): Boolean {

        val i = items.i

        var w = 0

        var fI = i

        sections.forEach { section ->
            sI = items.i

            val test = section.test(items)

            fI = items.i

            if (test && w < items.i) w = items.i

            items.i = i
        }


        val test = when {

            w > 0 -> {
                items.i = w
                true
            }

            w == 0 -> {
                items.i = fI
                false
            }

            else -> false
        }


       // if (test) collect(items, sI, name)

        return test
    }
}