package lib.matcher.sections


import lib.matcher.TestableStatic
import lib.matcher.items.ItemsStatic.Class as ItemsClass

class ZeroOrManySection<T> : RepetitiveSection<T> {

    constructor(vararg section: TestableStatic<T>)
            : super(*section, minCount = 0)

    constructor(vararg sections: TestableStatic<T>, name: String? = null, maxCount: Int)
            : super(*sections, name = name, minCount = 0, maxCount = maxCount)

    override fun test(items: ItemsClass<T>): Boolean {
        val i = items.i

        if (!super.test(items)) items.i = i

        return true
    }

}