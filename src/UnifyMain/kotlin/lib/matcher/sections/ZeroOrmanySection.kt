package lib.matcher.sections

import lib.matcher.TestableClass


class ZeroOrManySectionStatic : RepetitiveSectionStatic() {
    override fun <Item : TestableClass> invoke(item: Item): RepetitiveSectionClass<Item> {
        return ZeroOrManySectionClass(item)
    }
}


class ZeroOrManySectionClass<Item>(override val sectionItem: Item) : RepetitiveSectionClass<Item>(sectionItem, 0F)