package lib.matcher

import lib.matcher.sections.SectionStatic


abstract class MatcherStatic<T> : SectionStatic<T>() {

    abstract class Class<T>() : SectionStatic.Class<T>()
}