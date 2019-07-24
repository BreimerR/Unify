package lib.matcher.sections

import lib.matcher.TestableStatic
import lib.matcher.items.ItemsStatic.Class as ItemsClass

abstract class OptionalSectionStatic<T> : SectionStatic<T>() {
    abstract override operator fun invoke(vararg items: TestableStatic.Class<T>, name: String?): Class<T>
    /*{
        return Class(Section(*items), name = name)
    }*/

    abstract class Class<T>(section: TestableStatic.Class<T>, name: String? = null, self: OptionalSectionStatic<T>) :
            SectionStatic.Class<T>(section, name = name, self = self) {

        var test = false

        override fun test(items: ItemsClass<T>): Boolean {
            val i = items.i

            test = super.test(items)

            if (!test) items.i = i

            return true
        }
    }
}