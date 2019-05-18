package lib.pattern.patterns

import lib.pattern.items.Item
import lib.pattern.items.Items


abstract class Pattern<T>(protected open vararg val sections: Item<T>) {

    fun test(items: Items<T>) {
        var test = sections[0].test(items)
    }
}
