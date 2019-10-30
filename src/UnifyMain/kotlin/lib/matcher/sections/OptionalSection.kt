package lib.matcher.sections

import lib.matcher.TestableStatic
import lib.matcher.items.ItemsStatic


abstract class OptionalSectionStatic<T>(vararg sections: TestableStatic<T>) : SectionStatic<T>(*sections) {

    var test: Boolean = true

    // 170902
    override fun test(items: ItemsStatic.Class<T>): Boolean {

        val i = items.i

        for (section in sections) {

            test = section test items

            if (test) {
                when (section) {
                    is OptionalSectionStatic<T> -> {
                        test = section.test
                    }

                    is RepetitiveSectionStatic<T> -> {
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