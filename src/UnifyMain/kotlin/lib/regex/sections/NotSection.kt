package regex.sections

import lib.matcher.TestableStatic
import lib.matcher.sections.NotSectionStatic as LNotSectionStatic


class NotSectionStatic : LNotSectionStatic<Char>() {
    override fun invoke(vararg items: TestableStatic.Class<Char>, name: String?): Class {
        return Class(*items, name = name)
    }

    class Class(vararg items: TestableStatic.Class<Char>, name: String? = null) :
            LNotSectionStatic.Class<Char>(*items, name = name, self = NotSection)
}

val NotSection = NotSectionStatic()





