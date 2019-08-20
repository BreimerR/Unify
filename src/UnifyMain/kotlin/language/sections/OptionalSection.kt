package language.sections

import lib.matcher.TestableStatic
import lib.matcher.items.ItemsStatic.Class as ItemsClass
import lib.matcher.sections.OptionalSectionStatic as LOptionalSectionStatic
import lib.matcher.sections.OptionalSectionStatic.Class as OptionalClass

class OptionalSectionStatic : LOptionalSectionStatic<String>() {
    override fun invoke(vararg items: TestableStatic.Class<String>, name: String?): Class {
        return Class(*items, name = name)
    }

    class Class(vararg sections: TestableStatic.Class<String>, name: String? = null) :
            OptionalClass<String>(*sections, name = name, self = OptionalSection)
}


val OptionalSection = OptionalSectionStatic()