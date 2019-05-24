package lib.matcher.sections

import lib.matcher.TestableClass

/**@description
 * This class offers the capability to test cases
 * for existence of either case 1,2 ......n where n is a finite
 * */

class AlternativeSectionStatic : SectionStatic() {
    override fun <Item : TestableClass> invoke(item: Item): SectionClass<Item> {
        TODO("Implement this section return super.invoke(item)")
    }
}

class AlternativeSectionClass<Item>(override val sectionItem: Item) : SectionClass<Item>(sectionItem) {
    override val self = AlternativeSection
}

val AlternativeSection = AlternativeSectionStatic()