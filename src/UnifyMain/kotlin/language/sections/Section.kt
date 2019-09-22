package language.sections

import lib.matcher.TestableStatic
import lib.matcher.sections.SectionStatic as LSectionStatic


class SectionStatic : LSectionStatic<String>() {

    override fun invoke(vararg items: TestableStatic.Class<String>, name: String?) = Class(*items, name = name)


    class Class(vararg items: TestableStatic.Class<String>, name: String?) :
            LSectionStatic.Class<String>(*items, name = name, self = Section)

}

val Section = SectionStatic()


