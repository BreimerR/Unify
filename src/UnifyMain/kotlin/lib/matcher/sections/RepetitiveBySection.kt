package lib.matcher.sections

import lib.matcher.TestableStatic


class RepetitiveBySection<T> : Section<T> {

    constructor(
            section: TestableStatic<T>,
            by: TestableStatic<T>,
            name: String? = null) :
            super(section, RepetitiveSection(by, section), name = name)

    constructor(
            section: TestableStatic<T>,
            by: TestableStatic<T>,
            name: String? = null,
            maxCount: Int) :
            super(section, RepetitiveSection(by, section, maxCount = maxCount), name = name)

    constructor(
            section: TestableStatic<T>,
            by: TestableStatic<T>,
            name: String? = null,
            minCount: Int,
            maxCount: Int) :
            super(section, RepetitiveSection(by, section, minCount = minCount, maxCount = maxCount), name = name)
}