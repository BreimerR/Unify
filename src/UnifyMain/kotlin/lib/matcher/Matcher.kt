package lib.matcher


import lib.matcher.sections.SectionStatic
import lib.oop.classes.StaticClass
import lib.matcher.items.ItemsStatic.Class as ItemsClass
import lib.matcher.TestableStatic.Class as TestableClass

// A standard way to results for a particular search
// Searches must be type sensitive i.e regex searcher can not be used to generate
// tokens parser
abstract class MatcherStatic<in T> : StaticClass() {

    // TODO TestableClass<T>
    // secure comparison requirements of the library.
    abstract class Class<T>(vararg val sections: TestableClass<T>) : lib.oop.classes.Class<MatcherStatic<T>>() {

        lateinit var items: ItemsClass<T>

        var results: Array<List<T>>? = null
            get() {
                if (field == null) {

                    field = arrayOf()

                    for ((_, range) in ranges) {
                        field?.plus(items[range])
                    }
                }

                return field
            }

        open var ranges = arrayOf<Pair<String?, IntRange>>()

        /**
         * {
         *      0:"www",
         *      // named search case
         *      1:["domain_name","smile.com",[// any other separations will be stored here]],
         *      // unnamed search
         *      2:"some mor"
         * }*/
        infix fun test(items: ItemsClass<T>): Boolean {

            this.items = items

            var sI: Int

            sections.forEach { section ->
                sI = items.i
                if (section test items) {
                    ranges += section.collect(sI,items)
                } else return false
            }

            if (items.hasRemItems) return false

            return true
        }

        protected open fun collect(sI: Int, section: TestableStatic.Class<T>) {
            when (section) {
                is SectionStatic.Class<T> -> {
                    ranges += section.ranges
                }
                else -> ranges += null to sI..items.i

                // doing a collection for testable
            }
        }

    }
}