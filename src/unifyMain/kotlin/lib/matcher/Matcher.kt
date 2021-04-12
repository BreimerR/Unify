package lib.matcher

import lib.matcher.sections.SectionStatic


abstract class MatcherStatic<T>(vararg sections: TestableStatic<T>) : SectionStatic<T>(*sections)