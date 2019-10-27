package language.sections

import lib.matcher.TestableStatic
import lib.matcher.items.ItemsStatic

open class RepetitiveSectionStatic<T>(val minCount: Int = 0, val maxCount: Int = 1000) : SectionStatic<T>() {

    operator fun invoke(vararg sections: TestableStatic.Class<T>, minCount: Int = this.minCount, maxCount: Int = this.maxCount): Class<T> {
        return Class(*sections, minCount = minCount, maxCount = maxCount)
    }

    open class Class<T>(vararg sections: TestableStatic.Class<T>, val minCount: Int, val maxCount: Int) : SectionStatic.Class<T>(*sections) {

        override val self by lazy {
            RepetitiveSection
        }

        var tCounts = 0

        var test: Boolean = true

        private inline val testable
            get() = tCounts < maxCount

        private inline val minSuccess: Boolean
            get() = tCounts >= minCount

        override fun test(items: ItemsStatic.Class<T>): Boolean {
            var i: Int = items.i

            recurTest@ while (testable) {
                i = items.i

                test = tests(items)

                if (!test) break@recurTest

            }


            return if (minCount <= 0) {
                items.i = i

                true
            } else test
        }

        private fun tests(items: ItemsStatic.Class<T>): Boolean {

            var truth = false

            testLoop@ for (section in sections) {
                if (section test items) {
                    when (section) {
                        is Class<T> -> {
                            truth = section.test
                        }

                        is OptionalSectionStatic.Class<T> -> {
                            truth = section.test
                        }
                    }

                    if (!truth) break@testLoop
                } else break@testLoop

            }

            return truth
        }
    }
}

val RepetitiveSection = RepetitiveSectionStatic<String>()