package unify.sections

import lib.matcher.TestableStatic
import unify.ast.TokensStatic


open class RepetitiveSection(vararg sections: TestableStatic, val minCount: Int = 0, val maxCount: Int = 10000000) : Section(*sections) {

    var tCounts = 0
    var mCounts = 0

    private inline val testable
        get() = mCounts < maxCount

    private inline val minSuccess: Boolean
        get() = tCounts >= minCount

    override infix fun test(items: TokensStatic.Class): Boolean {
        var i = items.i

        while (testable && super.test(items)) {
            i = items.i
            mCounts += 1
            tCounts += 1
        }


        return if (minSuccess) {
            items.i = i
            true
        } else false
    }

}

/*
AnySection.kt
GroupedSection.kt
NotSection.kt

*/