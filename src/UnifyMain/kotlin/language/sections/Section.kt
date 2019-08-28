package language.sections

import lib.matcher.TestableStatic
import lib.matcher.items.ItemsStatic
import lib.matcher.sections.SectionStatic as LSectionStatic
import lib.matcher.sections.SectionStatic.Class  as SectionClass


class SectionStatic : LSectionStatic<String>() {
    override fun invoke(vararg items: TestableStatic.Class<String>, name: String?): Class {
        return Class(*items, name = name)
    }


    class Class(vararg items: TestableStatic.Class<String>, name: String?) :
            LSectionStatic.Class<String>(*items, name = name,self = Section) {}

}

val Section = SectionStatic()


