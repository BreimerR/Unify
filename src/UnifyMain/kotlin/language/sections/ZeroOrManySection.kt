package language.sections


import lib.matcher.TestableStatic
import lib.matcher.items.ItemsStatic.Class as ItemsClass
import lib.matcher.sections.ZeroOrManySectionStatic as LZeroOrManySectionStatic

class ZeroOrManySectionStatic : LZeroOrManySectionStatic<String>() {
    override fun invoke(vararg items: TestableStatic.Class<String>, name: String?, maxCount: Int): Class {
        return Class(*items, name = name, maxCount = maxCount)
    }

    override fun invoke(vararg items: TestableStatic.Class<String>, name: String?): Class {
        return Class(*items, name = name)
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

    class Class(vararg sections: TestableStatic.Class<String>, name: String?, maxCount: Int = ZeroOrManySection.maxCount) :
            LZeroOrManySectionStatic.Class<String>(*sections, name = name, maxCount = maxCount, self = ZeroOrManySection)
}

val ZeroOrManySection = ZeroOrManySectionStatic()