package regex.sections

import lib.matcher.TestableStatic

class OptionalSectionStatic : lib.matcher.sections.OptionalSectionStatic<Char>() {
    override fun invoke(vararg items: TestableStatic.Class<Char>, name: String?): Class {
        return Class(Section(*items), name)
    }

    class Class(section: TestableStatic.Class<Char>, name: String? = null) :
            lib.matcher.sections.OptionalSectionStatic.Class<Char>(section = section, name = name, self = OptionalSection)


}

val OptionalSection = OptionalSectionStatic()