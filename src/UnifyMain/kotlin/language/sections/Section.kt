package language.sections

import lib.matcher.TestableStatic
import lib.matcher.sections.SectionStatic as LSectionStatic
import lib.matcher.sections.SectionStatic.Class  as SectionClass


class SectionStatic : LSectionStatic<String>() {
    override fun invoke(vararg items: TestableStatic.Class<String>, name: String?): Class {
        return Class(items, name)
    }


    class Class(items: Array<out TestableStatic.Class<String>>, name: String?) :
            SectionClass<String>(*items, name = name, self = Section) {

        override fun test(item: String): Boolean {
            return false
        }
    }
}

val Section = SectionStatic()


