package regex.sections


import lib.matcher.TestableStatic
import lib.matcher.sections.RepetitiveSectionStatic as LRepetitiveSectionStatic

class RepetitiveSectionStatic(minCount: Int = 0, maxCount: Int = 10000000) :
        LRepetitiveSectionStatic<Char>(minCount = minCount, maxCount = maxCount) {
    override fun invoke(item: TestableStatic.Class<Char>, name: String?, minCount: Int, maxCount: Int): Class {
        return Class(item, name, minCount, maxCount)
    }

    override fun invoke(vararg item: TestableStatic.Class<Char>, name: String?, minCount: Int, maxCount: Int): Class {
        return Class(Section(*item), name, minCount, maxCount)
    }

    override fun invoke(vararg items: TestableStatic.Class<Char>, name: String?): Class {
        return Class(Section(*items), name, minCount, maxCount)
    }


    class Class(section: TestableStatic.Class<Char>, name: String?, minCount: Int, maxCount: Int) :
            LRepetitiveSectionStatic.Class<Char>(section, name, self = RepetitiveSection, maxCount = maxCount, minCount = minCount)

}

val RepetitiveSection = RepetitiveSectionStatic()

/*
AnySection.kt
GroupedSection.kt
NotSection.kt

*/