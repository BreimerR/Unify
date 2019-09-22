package unify.sections


import lib.matcher.TestableStatic


class RepetitiveBySectionStatic(section: TestableStatic, by: TestableStatic, minCount: Int = 0, maxCount: Int = 50000) :
        Section(section, RepetitiveSection(Section(by, section), minCount = minCount, maxCount = maxCount))