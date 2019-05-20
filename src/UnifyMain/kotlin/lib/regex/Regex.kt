package lib.regex

import lib.matcher.MatcherClass
import lib.matcher.MatcherStatic
import lib.collections.array.invoke
import lib.text.each
import lib.matcher.sections.Section
import lib.matcher.sections.SectionClass

class RegexClass(vararg items: SectionClass<ItemClass>) : MatcherClass<MatcherStatic>() {

    val sections = arrayOf<SectionClass<ItemClass>>()

    infix fun test(case: String): Boolean {
        // break down to comparable parts

        return false
    }

    override val self = Regex

    constructor(pattern: String) : this(*Regex.prepItems(pattern))

    infix fun match(case: String) {
        // each pattern section should test and claim a section
        // breakdown to individual parts
        val items = Items(case)
        // test individual parts against predefined order of arrangement
        // i want to test and claim at the same time

    }

    fun addSection(vararg item: SectionClass<ItemClass>) {

    }

    fun addSection(string: String) {
        string.each {
            addSection(Section(Item(it)))
        }
    }
}


class RegexStatic : MatcherStatic() {
    // TODO @pattern = "email=([a-zA-Z0-9_]+)(@)([a-zA-Z0-9]*)(\.)(com|org|[a-zA-Z]{3})"
    operator fun invoke(pattern: String): RegexClass {
        return RegexClass(pattern)
    }
    // should return a sectio nwith what defined items
    /**
     * i.e if we have a*
     * this should return a repetitive section with the item a
     * */
    fun prepItems(items: String): Array<SectionClass<ItemClass>> {
        return arrayOf(Section(Item('e')))
    }
}


val Regex = RegexStatic()


fun main() {
    val regex = Regex("email=([a-zA-Z0-9_]+)(@)([a-zA-Z0-9]*)\\.(com|org|[a-zA-Z]{3})")

    regex.addSection("email")

    /**
     * return a simple boolean of weather or not the whole thing matches
     * */

}
