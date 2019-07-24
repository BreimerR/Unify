package regex.sections

import lib.matcher.TestableStatic
import lib.matcher.sections.AlternativeSectionStatic as LAlternativeSectionStatic

class AlternativeSectionStatic : LAlternativeSectionStatic<Char>() {

    override fun invoke(vararg items: TestableStatic.Class<Char>, name: String?): Class = Class(*items, name = name)


    class Class(vararg items: TestableStatic.Class<Char>, name: String? = null) :
            LAlternativeSectionStatic.Class<Char>(*items, name = name, self = AlternativeSection)


}


val AlternativeSection = AlternativeSectionStatic()