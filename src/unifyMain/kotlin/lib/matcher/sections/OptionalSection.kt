package lib.matcher.sections

import DEBUG
import Log
import language.ast.TokensStatic
import lib.matcher.TestableStatic
import lib.matcher.items.ItemsStatic


abstract class OptionalSectionStatic<T>(vararg sections: TestableStatic<T>, name: String? = null) : SectionStatic<T>(*sections, name = name) {

    var test: Boolean = true


    // 170902
    override fun test(items: ItemsStatic.Class<T>): Boolean {

        var testIndex: Int
        val indexBeforeTest = items.nextIndex

        tester@ for (section in sections) {

            testIndex = items.nextIndex

            Log.d(TAG, "Start token = " + items.currentItem.toString())
            test = section test items
            Log.d(TAG, "End token = " + items.currentItem.toString())

            if (test) {
                if (items.nextIndex > testIndex) continue else if (section is OptionalSectionStatic<T> || section is RepetitiveSectionStatic<T>) continue
            }

            items.nextIndex = indexBeforeTest

            break@tester
        }

        return sections.isNotEmpty()
    }


    fun debug(message: String) {
        if (DEBUG) {
            Log.d(TAG, message)
        }
    }

}