package lib.matcher.sections

import lib.oop.classes.Class
import lib.oop.classes.StaticClass

open class SectionStatic : StaticClass() {
    operator fun <Item> invoke(item: Item): SectionClass<Item> {
        return SectionClass(item)
    }
}

open class SectionClass<Item>(val sectionItem: Item) : Class<SectionStatic>() {
    override val self = Section


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