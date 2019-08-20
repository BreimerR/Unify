package language.sections

import lib.matcher.TestableStatic
import lib.matcher.sections.NotSectionStatic as LNotSectionStatic
import lib.matcher.sections.NotSectionStatic.Class as NotSectionClass


class NotSectionStatic : LNotSectionStatic<String>() {
    override fun invoke(vararg items: TestableStatic.Class<String>, name: String?): Class {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    class Class(vararg items: TestableStatic.Class<String>, name: String? = null, self: NotSectionStatic) :
            NotSectionClass<String>(*items, name = name, self = self)

}






