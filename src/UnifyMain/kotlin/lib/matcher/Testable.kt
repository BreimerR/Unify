package lib.matcher

import lib.matcher.items.ItemsStatic
import lib.oop.classes.StaticClass
import unify.ast.TokensStatic
import lib.oop.classes.Class as OClass
import lib.matcher.items.ItemsStatic.Class as ItemsClass

interface TestableStatic<T> {

    infix fun test(items: ItemsStatic.Class<T>): Boolean

    // abstract fun collect(sI: Int, items: ItemsClass<T>): Array<Pair<String?, IntRange>>

    interface Class<T>

}


