package language.sections

import language.ast.TokensStatic
import lib.matcher.TestableStatic
import lib.matcher.items.ItemsStatic
import language.sections.RepetitiveSection as LRepetitiveSection


class RepetitiveBySection : LRepetitiveSection {

    override var considerSpaces: Boolean = false

    constructor(
            section: TestableStatic<String>,
            by: TestableStatic<String>,
            considerSpaces: Boolean = false,
            name: String? = null) :
            super(section, LRepetitiveSection(by, section), name = name, considerSpaces = considerSpaces)

    constructor(
            section: TestableStatic<String>,
            by: TestableStatic<String>,
            considerSpaces: Boolean = true,
            name: String? = null,
            maxCount: Int) :
            super(section, LRepetitiveSection(by, section, maxCount = maxCount), name = name, considerSpaces = considerSpaces)


    constructor(
            section: TestableStatic<String>,
            by: TestableStatic<String>,
            considerSpaces: Boolean = false,
            name: String? = null,
            minCount: Int,
            maxCount: Int
    ) : super(section, LRepetitiveSection(by, section, minCount = minCount, maxCount = maxCount), name = name, considerSpaces = considerSpaces)

    override infix fun test(items: ItemsStatic.Class<String>): Boolean {
        return if (items is TokensStatic.Class) {
            val spaceCons = items.considerSpaces

            items.considerSpaces = considerSpaces
            val t = super.test(items)
            items.considerSpaces = spaceCons
            t
        } else {
            super.test(items)
        }
    }
}