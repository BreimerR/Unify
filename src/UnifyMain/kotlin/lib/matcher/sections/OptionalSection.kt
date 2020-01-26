package lib.matcher.sections

import lib.matcher.TestableStatic
import lib.matcher.items.ItemsStatic


abstract class OptionalSectionStatic<T>(vararg sections: TestableStatic<T>) : SectionStatic<T>(*sections) {

    var test: Boolean = true

    // 170902
    override fun test(items: ItemsStatic.Class<T>): Boolean {

        var tI: Int
        val i = items.i

        for (section in sections) {

            tI = items.i
            test = section test items

            if (test) {
                if (items.i > tI) continue else if (section is OptionalSectionStatic<T> || section is RepetitiveSectionStatic<T>) continue
            }

            break
        }

        if (!test) items.i = i

        return sections.isNotEmpty()
    }


}