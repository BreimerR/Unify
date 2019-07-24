package lib.matcher.sections

import lib.matcher.TestableStatic


abstract class RepetitiveBySectionStatic<T> : SectionStatic<T>() {
    abstract val Repetitive: RepetitiveSectionStatic<T>

    abstract operator fun invoke(section: TestableStatic.Class<T>,
                                 by: TestableStatic.Class<T>,
                                 name: String?, maxCount: Int): Class<T>


    abstract operator fun invoke(section: TestableStatic.Class<T>,
                                 by: TestableStatic.Class<T>,
                                 name: String?, minCount: Int, maxCount: Int): Class<T>

    abstract override operator fun invoke(vararg items: TestableStatic.Class<T>, name: String?): Class<T>


    abstract class Class<T> :
            SectionStatic.Class<T> {
        constructor(
                section: TestableStatic.Class<T>,
                by: TestableStatic.Class<T>,
                name: String?,
                self: RepetitiveBySectionStatic<T>) : super(section, self.Repetitive(by, section), name = name, self = self)

        constructor(
                section: TestableStatic.Class<T>,
                by: TestableStatic.Class<T>,
                name: String?,
                maxCount: Int,
                self: RepetitiveBySectionStatic<T>) :
                super(section, self.Repetitive(by, section, maxCount = maxCount), name = name, self = self)

        constructor(
                section: TestableStatic.Class<T>,
                by: TestableStatic.Class<T>,
                name: String?,
                minCount: Int,
                maxCount: Int,
                self: RepetitiveBySectionStatic<T>) :
                super(section, self.Repetitive(by, section, minCount = minCount, maxCount = maxCount), name = name, self = self)
    }
}