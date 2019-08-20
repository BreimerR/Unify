package language.sections

import lib.collections.array.get
import lib.matcher.TestableStatic
import lib.matcher.sections.RepetitiveSectionStatic
import lib.matcher.sections.RepetitiveBySectionStatic.Class as RepetitiveByClass
import lib.matcher.sections.RepetitiveBySectionStatic as LRepetitiveBySectionStatic


class RepetitiveBySectionStatic : LRepetitiveBySectionStatic<String>() {

    override val Repetitive: RepetitiveSectionStatic<String> = RepetitiveSection

    override fun invoke(section: TestableStatic.Class<String>, by: TestableStatic.Class<String>, name: String?, maxCount: Int):
            Class {
        return Class(
                section,
                by,
                name,
                maxCount
        )
    }


    override fun invoke(section: TestableStatic.Class<String>, by: TestableStatic.Class<String>, name: String?, minCount: Int, maxCount: Int):
            Class {
        return Class(
                section = section,
                by = by,
                name = name,
                maxCount = maxCount
        )
    }

    override fun invoke(vararg items: TestableStatic.Class<String>, name: String?): Class {
        return Class(
                section = Section(*items[0 until items.size - 1].toTypedArray()),
                by = items.last(),
                name = name
        )
    }

    class Class :
            RepetitiveByClass<String> {

        constructor(
                section: TestableStatic.Class<String>,
                by: TestableStatic.Class<String>,
                name: String?
        ) : super(
                section,
                RepetitiveBySection.Repetitive(by, section),
                name = name,
                self = RepetitiveBySection)

        constructor(
                section: TestableStatic.Class<String>,
                by: TestableStatic.Class<String>,
                name: String?,
                maxCount: Int
        ) : super(
                section,
                RepetitiveBySection.Repetitive(by, section, maxCount = maxCount),
                name = name,
                self = RepetitiveBySection)

        constructor(
                section: TestableStatic.Class<String>,
                by: TestableStatic.Class<String>,
                name: String?,
                minCount: Int,
                maxCount: Int
        ) : super(
                section,
                RepetitiveBySection.Repetitive(by, section, minCount = minCount, maxCount = maxCount),
                name = name,
                self = RepetitiveBySection)
    }
}


val RepetitiveBySection = RepetitiveBySectionStatic()