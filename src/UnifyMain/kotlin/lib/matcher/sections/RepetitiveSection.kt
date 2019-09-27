package lib.matcher.sections


import lib.matcher.TestableStatic
import lib.matcher.items.ItemsStatic
import lib.matcher.items.ItemsStatic.Class as ItemsClass

open class RepetitiveSection<T>(vararg sections: TestableStatic<T>, name: String? = null, open val minCount: Int = 0, open val maxCount: Int = 10000000) :
        Section<T>(*sections, name = name) {

    var tCounts = 0

    var mCounts = 0

    private inline val testable
        get() = mCounts < maxCount

    private inline val minSuccess: Boolean
        get() = tCounts >= minCount

    override infix fun test(items: ItemsStatic.Class<T>): Boolean {
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
