package regex

import libs.text.each
import matcher.MatcherStatic
import lib.matcher.TestableStatic
import lib.matcher.TestableStatic.Class as TestableClass


infix fun Char.Is(char: Char): Boolean {
    return this == char
}

class RegexStatic : MatcherStatic<Char>() {
    // TODO @pattern = "email=([a-zA-Z0-9_]+)(@)([a-zA-Z0-9]*)(\.)(com|org|[a-zA-Z]{3})"
    operator fun invoke(patternString: String): Class {
        return Class(*getSections(patternString))
    }

    private fun getSections(pattern: String): Array<out TestableStatic.Class<Char>> {


        return arrayOf()
    }

    fun getSection(pattern: String): TestableStatic.Class<Char>? {
        return null
    }


    operator fun invoke(vararg sections: TestableClass<Char>): Class {
        return Class(*sections)
    }

    fun parsePatternString(string: String) {
        // EXAMPLE :
        // ^<name>abc.*[c-d]!(aaah)(simple|name)\$$
        var char: Char? = null


        string.each(true) { it: Char, index: Int ->
            val i = index

            if (it == '^') {

            }



            i + 1
        }
    }


    /*operator fun invoke(patternString: String, flags: String = "g"): RegexClass {

        // TODO Regex takes in a compiled pattern
        // generate pattern from parsing a string
        // The generated pattern class is what is used inside the RegexClass
        @Suppress("UnnecessaryVariable") val reg = RegexClass(patternString)

        // Process flags

        // Add flags to the regular expression parser

        return reg

    }*/
    // should return a section with what defined items
    /**
     * i.e if we have a*
     * this should return a repetitive section with the item a
     * */
    /*fun prepItems(items: String): Array<SectionClass<ItemClass>> {
        return arrayOf(Section(Item('e')))
    }*/


    /**TODO
     *
     * decide on a return type for the parse section
     * */

    fun parseFlags(flags: String) {

    }


    class Class(vararg sections: TestableClass<Char>, flags: String = "g") : MatcherStatic.Class<Char>(*sections) {

        infix fun test(case: String): Boolean {
            // grouping and named groups has to be ready for this to be ready
            return false
        }


        override val self = Regex

        /*constructor(pattern: String) : this(*Regex.prepItems(pattern))*/

        infix fun match(case: String): MatchedClass = Matched()

        /*fun addSection(vararg item: SectionClass<ItemClass>) = Unit*/


        operator fun get(key: String): List<Char> {
            for ((name, range) in ranges) {
                if (name == key) return items[range]
            }

            return listOf()
        }
    }


}


val Regex = RegexStatic()

