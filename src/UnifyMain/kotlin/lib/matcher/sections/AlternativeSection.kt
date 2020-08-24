package lib.matcher.sections

import language.sections.PassiveSection
import lib.collections.array.pop
import lib.matcher.TestableStatic
import lib.matcher.items.ItemsStatic


abstract class AlternativeSectionStatic<T>(override vararg var sections: TestableStatic<T>) : SectionStatic<T>(*sections) {

    override fun test(items: ItemsStatic.Class<T>): Boolean {

        var eI: Int = items.nextIndex

        var sI = 0


        for (section in sections) {

            val i = items.nextIndex

            Log.d(TAG, "Start token = " + items.currentItem.toString())

            val test = section test items

            Log.d(TAG, "End token = " + items.currentItem.toString())


            eI = items.nextIndex

            if (test) {

                if (section is SingleInstanceSection<T>) {
                    if (items.nextIndex > i) sections = sections.pop(sI).toTypedArray()
                    sI = 0
                }

                // TODO save found section to avoid re test on collection
                if (section is PassiveSection && section.test) {

                    return true
                }

                // TODO nested sections failure ie Alternative(Section(PassiveSection))
                if (items.nextIndex > i) {
                    return true
                }

            }
            sI += 1;
            // revert i for re test
            items.nextIndex = i

        }

        items.nextIndex = eI

        return false
    }

}

