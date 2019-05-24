package lib.regex

import lib.matcher.TestableClass
import lib.matcher.TestableStatic
import lib.oop.classes.Class
import lib.oop.classes.StaticClass


class ItemsStatic : TestableStatic() {
    operator fun invoke(testCase: String): ItemsClass {
        return ItemsClass(testCase)
    }
}

class ItemsClass(val testCase: String) : TestableClass() {

    override val self = Items

    override fun test(items: TestableClass): Boolean {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}

val Items = ItemsStatic()