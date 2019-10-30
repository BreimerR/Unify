package lib.matcher.sections

import lib.collections.array.get
import lib.collections.array.last
import lib.matcher.TestableStatic

open class RepetitiveBySection<T>(vararg sections: TestableStatic<T>, minCount: Int = 1, maxCount: Int) : RepetitiveSectionStatic<T>(
        *sections[0..sections.size - 2].toTypedArray(),
        ZeroOrManyStatic(
                sections.last,
                *sections[0..sections.size - 2].toTypedArray(),
                maxCount = maxCount
        )
) {

    constructor(
            vararg sections: TestableStatic<T>,
            by: TestableStatic<T>,
            minCount: Int = 1,
            maxCount: Int = RepetitiveSectionStatic.maxCount
    ) : this(*sections, by, minCount = minCount, maxCount = maxCount)
}