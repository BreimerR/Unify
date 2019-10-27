package language.sections

import lib.matcher.TestableStatic
import lib.matcher.items.ItemsStatic

class OptionalSectionStatic<T> : SectionStatic<T>() {

    override operator fun invoke(vararg sections: TestableStatic.Class<T>): Class<T> = Class(*sections)

    class Class<T>(vararg sections: TestableStatic.Class<T>) : SectionStatic.Class<T>(*sections) {

        override val self by lazy {
            OptionalSection
        }

        var test: Boolean = true

        // 170902
        override fun test(items: ItemsStatic.Class<T>): Boolean {

            val i = items.i

            for (section in sections) {

                test = section test items

                if (test) {
                    when (section) {
                        is Class<T> -> {
                            test = section.test
                        }

                        is RepetitiveSectionStatic.Class<T> -> {
                            test = section.test
                        }
                    }

                    if (test) continue
                }

                break
            }

            if (!test) items.i = i

            return true
        }


    }
}

val OptionalSection = OptionalSectionStatic<String>()