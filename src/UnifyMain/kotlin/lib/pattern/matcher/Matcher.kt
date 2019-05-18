package lib.pattern.matcher


import lib.oop.classes.Class
import lib.oop.classes.StaticClass
import lib.pattern.items.Item
import lib.pattern.items.Items


abstract class MatcherStatic : StaticClass() {
    // pattern Items must be destructed.
    // operator fun <T> invoke(vararg patternItems: Item<T>): MatcherClass<T> = MatcherClass(*patternItems)
}


abstract class MatcherClass<T>(vararg var patternItems: Item<T>) : Class<MatcherStatic>() {
    abstract val found: Array<MatchResult<T>>?

    // on successful section test
    // get groups as requested
    abstract fun match(items: Items<T>): Array<out MatchResult<T>>

    abstract fun test(items: Items<T>): Boolean
}