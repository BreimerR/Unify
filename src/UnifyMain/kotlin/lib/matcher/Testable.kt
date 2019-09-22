package lib.matcher

import lib.oop.classes.StaticClass
import unify.ast.TokensStatic
import lib.oop.classes.Class as OClass
import lib.matcher.items.ItemsStatic.Class as ItemsClass

abstract class TestableStatic : StaticClass() {

    abstract fun test(items: TokensStatic.Class): Boolean

    abstract class Class<T> : OClass<TestableStatic>() {
        abstract infix fun test(item: T): Boolean

        abstract infix fun test(items: ItemsClass<T>): Boolean

        abstract fun collect(sI: Int, items: ItemsClass<T>): Array<Pair<String?, IntRange>>
    }

}


