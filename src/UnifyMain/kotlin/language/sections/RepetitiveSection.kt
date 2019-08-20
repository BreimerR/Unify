package language.sections


import lib.matcher.TestableStatic
import lib.matcher.items.ItemsStatic.Class as ItemsClass
import lib.matcher.sections.RepetitiveSectionStatic as LRepetitiveSectionStatic
import lib.matcher.sections.RepetitiveSectionStatic.Class as RepetitiveSectionClass

open class RepetitiveSectionStatic :
        LRepetitiveSectionStatic<String>() {

    override fun invoke(item: TestableStatic.Class<String>, name: String?, minCount: Int, maxCount: Int): Class {
        return Class(item, name, minCount, maxCount)
    }

    override fun invoke(vararg item: TestableStatic.Class<String>, name: String?, minCount: Int, maxCount: Int): Class {
        return Class(Section(*item), name, minCount, maxCount)
    }

    override fun invoke(vararg items: TestableStatic.Class<String>, name: String?): Class {
        return Class(Section(*items), name, minCount, maxCount)
    }

    class Class(item: TestableStatic.Class<String>, name: String?, minCount: Int, maxCount: Int) :
            RepetitiveSectionClass<String>(item, name = name, minCount = minCount, maxCount = maxCount, self = RepetitiveSection)
}


val RepetitiveSection = RepetitiveSectionStatic()