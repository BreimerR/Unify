package lib.matcher

import lib.matcher.sections.SectionStatic


abstract class MatcherStatic<T> : SectionStatic<T>() {

    abstract class Class<T>(vararg sections: TestableStatic<T>) : SectionStatic.Class<T>(*sections)
}