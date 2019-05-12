package lib.pattern.matcher


import lib.patternMatcher.items.Item
import lib.patternMatcher.items.Items


abstract class Matcher<T>(vararg var patternItems: Item<T>) {

    abstract val found: Array<MatchResult<T>>?

    // on successful section test
    // get groups as requested
    abstract fun match(items: Items<T>): Array<out MatchResult<T>>

    abstract fun test(items: Items<T>): Boolean
}
