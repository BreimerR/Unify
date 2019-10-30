package lib.matcher.sections

import lib.collections.array.pop
import lib.collections.array.last
import lib.matcher.TestableStatic

abstract class RepetitiveBySection<T>(vararg sections: TestableStatic<T>, minCount: Int = 1, maxCount: Int) : RepetitiveSectionStatic<T>(
        SectionStatic(
                *sections.pop,
                sections.last,
                ZeroOrManyStatic(
                        *sections.pop,
                        sections.last,
                        maxCount = maxCount
                )
        ),
        minCount = minCount) {

    constructor(
            vararg sections: TestableStatic<T>,
            by: TestableStatic<T>,
            minCount: Int = 1,
            maxCount: Int = RepetitiveSectionStatic.maxCount
    ) : this(*sections, by, minCount = minCount, maxCount = maxCount)
}