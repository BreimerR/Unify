package regex.sections

import lib.matcher.TestableStatic
import lib.matcher.sections.SectionStatic as LSectionStatic

class SectionStatic : LSectionStatic<Char>() {
    override fun invoke(vararg items: TestableStatic.Class<Char>, name: String?): Class {
        return Class(*items, name = name)
    }

    class Class(vararg sectionItems: TestableStatic.Class<Char>, name: String?) :
            LSectionStatic.Class<Char>(*sectionItems, name = name, self = Section)
}


val Section = SectionStatic()