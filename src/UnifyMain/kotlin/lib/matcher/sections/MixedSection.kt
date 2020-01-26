package lib.matcher.sections

import lib.collections.array.pop
import lib.matcher.TestableStatic
import lib.matcher.items.ItemsStatic

open class MixedSectionStatic<T>(vararg sections: TestableStatic<T>) : SectionStatic<T>(*sections) {

    override fun test(items: ItemsStatic.Class<T>): Boolean {
        var test = true

        var sections = this.sections

        var i = 0


        var optionals = arrayOf<TestableStatic<T>>()

        for (section in sections) {
            val lastIndex = sections.size - 1
            val iC = items.i

            var isOptional = false


            var t = section test items


            when (section) {
                is RepetitiveSectionStatic<T> -> {
                    t = if (section.minCount == 0) section.test else t
                    optionals += section
                    isOptional = true
                }

                is OptionalSectionStatic<T> -> {
                    t = section.test
                    optionals += section
                    isOptional = true
                }
            }

            /**
             * test sample   a b c d v
             * test case     a d b c v
             * */
            when {
                t -> {
                    sections = sections.pop(i).toTypedArray()
                    i = 0
                }
                i == lastIndex -> {

                    var mSec = sections
                    for ((mI, s) in mSec.withIndex()) {
                        if (s in optionals) {
                            mSec = mSec.pop(mI).toTypedArray()
                        }
                    }

                    if (mSec.isNotEmpty()) test = false
                }
                else -> {
                    items.i = iC
                    i++
                }
            }
        }

        return sections.isNotEmpty() && test
    }
}