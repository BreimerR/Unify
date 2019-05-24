package lib.matcher.sections


import lib.matcher.TestableClass
import lib.matcher.TestableStatic

open class SectionStatic : TestableStatic() {
    open operator fun <Item : TestableClass> invoke(item: Item): SectionClass<Item> {
        return SectionClass(item)
    }
}

open class SectionClass<Item>(open val sectionItem: Item) : TestableClass() {
    override val self = Section

    override fun test(): Boolean {

        return false
    }


}

/**TODO
 * define sections
 * one or many denoted by +
 * zero or many section *
 * alternative sections |
 * range section -  Item-Item this is dependant of the pattern class i.e regex a-z or 0-9 and other pattern matchers that
 * could be out there
 * repetitive section one or many should extend here and also zero or many should extend from here
 * */

val Section = SectionStatic()