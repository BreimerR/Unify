package regex.sections

import lib.matcher.TestableStatic
import lib.matcher.sections.OneOrManySectionStatic as LOneOrManySectionStatic

class OneOrManySectionStatic(minCount: Int = 1) : LOneOrManySectionStatic<Char>(minCount = minCount) {
    override fun invoke(vararg items: TestableStatic.Class<Char>, name: String?): Class {
        return Class(Section(*items), name)
    }

    override fun invoke(item: TestableStatic.Class<Char>, name: String?, maxCount: Int): Class {
        return Class(item, name)
    }

    override fun invoke(item: TestableStatic.Class<Char>, name: String?, minCount: Int, maxCount: Int): Class {
        return Class(item, name)
    }

    override fun invoke(vararg item: TestableStatic.Class<Char>, name: String?, minCount: Int, maxCount: Int): Class {
        return Class(Section(*item), name)
    }


    /*= Class(item, name, maxCount = this.maxCount)*/

    /*= Class(Section(*items), name, maxCount = this.maxCount)*/

    open class Class(
            section: TestableStatic.Class<Char>,
            name: String?) :
            LOneOrManySectionStatic.Class<Char>(section, name, OneOrManySection.minCount, OneOrManySection)
}

val OneOrManySection = OneOrManySectionStatic()