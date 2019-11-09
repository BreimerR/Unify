package lib.matcher.sections

import lib.matcher.TestableStatic

open class SingleInstanceSection<T>(vararg sections: TestableStatic<T>) : SectionStatic<T>(*sections)