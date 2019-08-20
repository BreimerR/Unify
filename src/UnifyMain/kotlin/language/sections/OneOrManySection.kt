package language.sections

import lib.matcher.TestableStatic
import lib.matcher.sections.RepetitiveSectionStatic
import lib.matcher.sections.OneOrManySectionStatic as LOneOrManySectionStatic
import lib.matcher.sections.OneOrManySectionStatic.Class  as OneOrManyClass

class OneOrManySectionStatic(minCount: Int = 1) : LOneOrManySectionStatic<String>(minCount) {
    override fun invoke(vararg items: TestableStatic.Class<String>, name: String?): Class {
        return Class(*items, name = name, maxCount = maxCount)
    }

    override fun invoke(item: TestableStatic.Class<String>, name: String?, maxCount: Int): Class {
        return Class(item, name = name, maxCount = maxCount)
    }

    override fun invoke(item: TestableStatic.Class<String>, name: String?, minCount: Int, maxCount: Int): Class {
        return Class(item, name = name, maxCount = maxCount)
    }

    override fun invoke(vararg item: TestableStatic.Class<String>, name: String?, minCount: Int, maxCount: Int): Class {
        return Class(*item, name = name, maxCount = maxCount)
    }


    class Class(vararg items: TestableStatic.Class<String>, name: String?, maxCount: Int = 10000) :
            OneOrManyClass<String>(*items, name = name, self = OneOrManySection, maxCount = maxCount)


}


val OneOrManySection = OneOrManySectionStatic()