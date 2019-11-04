package lib.matcher.sections

import lib.collections.array.pop
import lib.matcher.TestableStatic
import lib.matcher.items.ItemsStatic

open class MixedSectionStatic<T>(vararg sections: TestableStatic<T>) : SectionStatic<T>(*sections) {

    override fun test(items: ItemsStatic.Class<T>): Boolean {
        var test = true

        var sections = this.sections

        var i = 0

        for (section in sections) {
            val lastIndex = sections.size - 1
            val iC = items.i

            when {
                section test items -> {
                    sections = sections.pop(i).toTypedArray()
                    i = 0
                }
                i == lastIndex -> test = false
                else -> {
                    items.i = iC
                    i++
                }
            }
        }

        return sections.isNotEmpty() && test
    }
}