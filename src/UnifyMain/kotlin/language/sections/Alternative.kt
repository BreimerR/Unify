package language.sections

import lib.matcher.TestableStatic
import lib.matcher.sections.AlternativeSectionStatic as LAlternativeSectionStatic
import lib.matcher.sections.AlternativeSectionStatic.Class  as AlternativeSectionClass

class AlternativeSectionStatic : LAlternativeSectionStatic<String>() {
    override fun invoke(vararg items: TestableStatic.Class<String>, name: String?): Class {
        return Class(items, name)
    }

    class Class(items: Array<out TestableStatic.Class<String>>, name: String?) :
            AlternativeSectionClass<String>(*items, name = name, self = AlternativeSection)
}

val AlternativeSection = AlternativeSectionStatic()