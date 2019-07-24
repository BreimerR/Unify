package regex.sections

import lib.matcher.TestableStatic
import lib.matcher.sections.RepetitiveSectionStatic
import lib.matcher.TestableStatic.Class as TClass
import lib.matcher.items.ItemsStatic.Class as ItemsClass
import lib.matcher.sections.RepetitiveBySectionStatic as LRepetitiveBySectionStatic
import lib.matcher.sections.SectionStatic as SectionStatic

class RepetitiveBySectionStatic : LRepetitiveBySectionStatic<Char>() {
    override val Repetitive: RepetitiveSectionStatic<Char>
        get() = RepetitiveSection


    override fun invoke(section: TestableStatic.Class<Char>, by: TestableStatic.Class<Char>, name: String?, maxCount: Int)
            : Class = Class(section, by, name, maxCount)


    override fun invoke(section: TestableStatic.Class<Char>, by: TestableStatic.Class<Char>, name: String?, minCount: Int, maxCount: Int)
            : Class = Class(section, by, name, minCount, maxCount)


    override fun invoke(vararg items: TestableStatic.Class<Char>, name: String?)
            : Class = Class(Section(*items[0 until items.size]), items.last(), name)


    class Class : LRepetitiveBySectionStatic.Class<Char> {

        constructor(section: TestableStatic.Class<Char>, by: TestableStatic.Class<Char>, name: String?) :
                super(section, by, name = name, self = RepetitiveBySection)

        constructor(section: TestableStatic.Class<Char>, by: TestableStatic.Class<Char>, name: String?, maxCount: Int) :
                super(section, by, name = name, self = RepetitiveBySection, maxCount = maxCount)


        constructor(section: TestableStatic.Class<Char>, by: TestableStatic.Class<Char>, name: String?, minCount: Int, maxCount: Int) :
                super(section, by, name = name, self = RepetitiveBySection, minCount = minCount, maxCount = maxCount)
    }
}

inline operator fun <reified T> Array<out T>.get(range: IntRange): Array<out T> {
    return this.slice(range - 1).toTypedArray()
}

val RepetitiveBySection = RepetitiveBySectionStatic()