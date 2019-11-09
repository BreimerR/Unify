package language.sections

import language.ast.TokensStatic
import lib.matcher.TestableStatic
import lib.matcher.items.ItemsStatic


open class Section(
        vararg sections: TestableStatic<String>,
        val considerSeparation: Boolean = false,
        val name: String? = null
) : lib.matcher.sections.SectionStatic<String>(*sections) {

    override fun test(items: ItemsStatic.Class<String>): Boolean {
        return if (items is TokensStatic.Class) {
            val considerSeparation = items.considerSeparation

            items.considerSeparation = this.considerSeparation
            val test = super.test(items)
            items.considerSeparation = considerSeparation

            test
        } else false

    }
}



