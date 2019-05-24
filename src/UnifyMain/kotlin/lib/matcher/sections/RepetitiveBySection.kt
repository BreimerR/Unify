package lib.matcher.sections

import lib.matcher.TestableClass

open class RepetitiveBySectionStatic : SectionStatic() {
    override operator fun <Item: TestableClass> invoke(item: Item): RepetitiveBySectionClass<Item> = RepetitiveBySectionClass(item)
}

open class RepetitiveBySectionClass<Item>(override val sectionItem: Item) : SectionClass<Item>(sectionItem) {
    /**TODO
     *
     * sItem = Section(sectionItem)
     * section = [
     *      sItem,
     *      ZeroOrMany(
     *          repeater,
     *          sItem
     *      )
     * ]
     * */
}

val RepetitiveBySection = RepetitiveBySectionStatic()