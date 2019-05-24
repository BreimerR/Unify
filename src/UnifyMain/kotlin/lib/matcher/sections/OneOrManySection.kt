package lib.matcher.sections

import lib.matcher.TestableClass
import platform.posix.INFINITY


class OneOrManySectionStatic : RepetitiveSectionStatic() {
    override operator fun <Item : TestableClass> invoke(item: Item): OneOrManySectionClass<Item> {
        return OneOrManySectionClass(item)
    }
}

class OneOrManySectionClass<Item>(override val sectionItem: Item) : RepetitiveSectionClass<Item>(sectionItem, 1F) {
    override val self = OneOrManySection
}

var OneOrManySection = OneOrManySectionStatic()