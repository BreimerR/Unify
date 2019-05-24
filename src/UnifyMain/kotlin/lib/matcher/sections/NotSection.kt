package lib.matcher.sections


/** @Class_Description
 * This is for cases where we have a......z but we want to get all alphabets that are not z
 * anything else but the provided item
 * */
class NotSectionStatic : SectionStatic()

class NotSectionCalss<Item>(override val sectionItem: Item) : SectionClass<Item>(sectionItem)

val NotSection = NotSectionStatic()