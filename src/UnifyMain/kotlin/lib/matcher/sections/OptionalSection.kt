package lib.matcher.sections

import lib.matcher.TestableStatic
import lib.matcher.items.ItemsStatic.Class as ItemsClass

class OptionalSection<T>(vararg sections: TestableStatic<T>, name: String? = null) :
        Section<T>(*sections, name = name) {

    var test = false

    override fun test(items: ItemsClass<T>): Boolean {
        val i = items.i

        test = super.test(items)

        if (!test) items.i = i

        return true
    }
}