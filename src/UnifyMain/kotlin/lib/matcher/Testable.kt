package lib.matcher

import lib.oop.classes.Class
import lib.oop.classes.StaticClass

abstract class TestableClass : Class<TestableStatic>() {
    abstract fun test(items: TestableClass): Boolean
}

abstract class TestableStatic : StaticClass()