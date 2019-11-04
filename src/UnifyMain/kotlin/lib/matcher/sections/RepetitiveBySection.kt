package lib.matcher.sections

import lib.matcher.TestableStatic


open class RepetitiveBySection<T> : SectionStatic<T> {

    constructor(
            section: TestableStatic<T>,
            by: TestableStatic<T>,
            name: String? = null) :
            super(section, RepetitiveSectionStatic(by, section))

    constructor(
            section: TestableStatic<T>,
            by: TestableStatic<T>,
            name: String? = null,
            maxCount: Int) :
            super(section, RepetitiveSectionStatic(by, section, maxCount = maxCount))

    constructor(
            section: TestableStatic<T>,
            by: TestableStatic<T>,
            name: String? = null,
            minCount: Int,
            maxCount: Int) :
            super(section, RepetitiveSectionStatic(by, section, minCount = minCount, maxCount = maxCount))

}