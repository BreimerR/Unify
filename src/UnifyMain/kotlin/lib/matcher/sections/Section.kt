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
import lib.collections.array.length
import lib.matcher.TestableStatic
import lib.matcher.items.ItemsStatic
import lib.matcher.items.ItemStatic.Class as ItemClass
import lib.matcher.items.ItemsStatic.Class as ItemsClass

open class Section<T>(open vararg val sections: TestableStatic<T>, val name: String? = null) : TestableStatic<T>() {

    var sI: Int = 0

    lateinit var items: ItemsClass<T>

    var eI: Int? = null

    private var obtained: Array<Pair<String?, Array<ItemClass<T>>>>? = null

    // name type range
    var ranges = arrayOf<Pair<String?, IntRange>>()


    fun collect(start: Int, end: Int, name: String? = null) {
        ranges += name to start..end

        items.i = end
    }


    override infix fun test(items: ItemsStatic.Class<T>): Boolean {

        this.items = items

        val i = items.i


        return if (sections.length > 0) {
            for (section in sections) {
                sI = items.i

                if (section test items) {
                    if (section is Section<T>) {
                        val sR = section.ranges

                        // collect(section.ranges)

                        var t = true

                        if (section is OptionalSection<T>) t = section.test

                        //if (t) collect(sR.first().second.first, sR.last().second.last, section.name)

                    } //else collect(items, sI)
                } else return false
            }
            // collect(items, i, name)
            true
        } else false
    }

    override fun collect(sI: Int, items: ItemsStatic.Class<T>): Array<Pair<String?, IntRange>> {
        return ranges
    }

    open fun collect(items: ItemsStatic.Class<T>, i: Int, name: String? = null) {
        collect(i, items.i, name)
    }

    fun collect(ranges: Array<Pair<String?, IntRange>>) {
        this.ranges += ranges
    }

}