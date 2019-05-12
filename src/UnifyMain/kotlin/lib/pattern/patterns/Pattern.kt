package lib.pattern.patterns

import lib.patternMatcher.items.Item
import lib.patternMatcher.items.Items


abstract class Pattern<T>(protected open vararg val sections: Item<T>) {

    fun test(items: Items<T>) {
        var test = sections[0].test(items)
    }
}
