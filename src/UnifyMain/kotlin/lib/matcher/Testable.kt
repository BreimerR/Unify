package lib.matcher

import lib.matcher.items.ItemsStatic
import lib.oop.classes.StaticClass
import unify.ast.TokensStatic
import lib.oop.classes.Class as OClass
import lib.matcher.items.ItemsStatic.Class as ItemsClass

abstract class TestableStatic<T> : StaticClass() {

    abstract infix fun test(items: ItemsStatic.Class<T>): Boolean

    abstract fun collect(sI: Int, items: ItemsClass<T>): Array<Pair<String?, IntRange>>

    abstract class Class<T> : OClass<TestableStatic<T>>()

}


