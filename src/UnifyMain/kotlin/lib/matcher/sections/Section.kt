package lib.matcher.sections

/**TODO
 * define sections
 * one or many denoted by +
 * zero or many section *
 * alternative sections |
 * range section -  Item-Item this is dependant of the pattern class i.e regex a-z or 0-9 and other pattern matchers that
 * could be out there
 * repetitive section one or many should extend here and also zero or many should extend from here
 * */
import lib.matcher.TestableStatic
import lib.matcher.items.ItemClass
import lib.matcher.items.ItemsStatic
import lib.matcher.items.ItemsStatic.Class as ItemsClass


abstract class SectionStatic<T> : TestableStatic() {

    abstract operator fun invoke(vararg items: TestableStatic.Class<T>, name: String? = null): Class<T>

    abstract class Class<T>(vararg sectionItems: TestableStatic.Class<T>, open val name: String? = null, override val self: SectionStatic<T>) : TestableStatic.Class<T>() {

        lateinit var items: ItemsClass<T>

        var sI = 0

        var eI: Int? = null

        var section: Class<T>? = null

        private var obtained: Array<Pair<String?, Array<ItemClass<T>>>>? = null

        // name type range
        open var ranges = arrayOf<Pair<String?, IntRange>>()


        protected val sections = sectionItems

        inline val close: Unit
            get() {
                closed = true
            }

        inline val open: Unit
            get() {
                closed = false
            }

        var closed = true

        override infix fun test(items: ItemsClass<T>): Boolean {
            this.items = items

            val i = items.i

            for (section in sections) {
                sI = items.i

                if (section test items) {
                    if (section is Class<T>) {
                        val sR = section.ranges
                        collect(section.ranges)

                        var t = true

                        if (section is OptionalSectionStatic.Class<T>) t = section.test

                        if (t) collect(sR.first().second.first, sR.last().second.last, section.name)

                    } else collect(items, sI)
                } else return false
            }

            collect(items, i, name)

            return true
        }

        open fun collect(items: ItemsStatic.Class<T>, i: Int, name: String? = null) {
            collect(i, items.i, name)
        }

        fun collect(ranges: Array<Pair<String?, IntRange>>) {
            this.ranges += ranges
        }

        open fun collect(start: Int, end: Int, name: String? = null) {
            ranges += name to start..end
        }

        fun test(test: TestableStatic.Class<T>, case: ItemsStatic.Class<T>): Boolean {
            return test test case
        }

    }
}

/**@description
 * @param sectionItems  this are the haystacks that want to get from an item order
 * @param name:String? = null this is the name that we can use to infer a specific
 * section of a pattern from the matched items
 * */