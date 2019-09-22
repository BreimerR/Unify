package language.sections

import lib.matcher.TestableStatic
import lib.matcher.sections.NotSectionStatic as LNotSectionStatic
import lib.matcher.sections.NotSectionStatic.Class as NotSectionClass


class NotSectionStatic : LNotSectionStatic<String>() {
    override fun invoke(vararg items: TestableStatic.Class<String>, name: String?): Class {
        return Class(*items, name = name)
    }

    class Class(vararg items: TestableStatic.Class<String>, name: String? = null) :
            NotSectionClass<String>(*items, name = name, self = NotSection)

}


val NotSection = NotSectionStatic()




