package lib.matcher.sections

import platform.posix.INFINITY


open class RepetitiveSectionClass<Item>(override val sectionItem: Item, val minCount: Float = 0F, val maxCount: Float = INFINITY) : SectionClass<Item>(sectionItem) {
    override val self = RepetitiveSection


}

open class RepetitiveSectionStatic : SectionStatic()

val RepetitiveSection = RepetitiveSectionStatic()