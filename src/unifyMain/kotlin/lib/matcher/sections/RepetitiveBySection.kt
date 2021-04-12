package lib.matcher.sections

import lib.matcher.TestableStatic


open class RepetitiveBySection<T> : SectionStatic<T> {

    constructor(
            section: TestableStatic<T>,
            by: TestableStatic<T>,
            name: String? = null
    ) : super(section, RepetitiveSectionStatic(by, section, minCount = 0), name = name)

    constructor(
            section: TestableStatic<T>,
            by: TestableStatic<T>,
            name: String? = null,
            maxCount: Int
    ) : super(section, RepetitiveSectionStatic(by, section, minCount = 0, maxCount = maxCount), name = name)

    constructor(
            section: TestableStatic<T>,
            by: TestableStatic<T>,
            name: String? = null,
            minCount: Int = 0,
            maxCount: Int
    ) : super(section, RepetitiveSectionStatic(by, section, minCount = minCount, maxCount = maxCount), name = name)

}