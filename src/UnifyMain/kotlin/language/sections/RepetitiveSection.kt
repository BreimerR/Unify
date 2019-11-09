package language.sections

import lib.matcher.TestableStatic


open class RepetitiveSection(vararg sections: TestableStatic<String>, minCount: Int = 1, maxCount: Int = this.maxCount) : lib.matcher.sections.RepetitiveSectionStatic<String>(*sections, minCount = minCount, maxCount = maxCount)