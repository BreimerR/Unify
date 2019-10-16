package lib.matcher.sections


import lib.matcher.TestableStatic
import lib.matcher.items.ItemStatic
import lib.matcher.items.ItemsStatic
import lib.matcher.items.ItemsStatic.Class as ItemsClass

open class AlternativeSection<T>(vararg sections: TestableStatic<T>, name: String? = null) :
        Section<T>(*sections, name = name) {

    // we dont want to find the first match but the best case match
    override infix fun test(items: ItemsClass<T>): Boolean {
        return test(items, sections)
    }

    private fun test(items: ItemsStatic.Class<T>, sections: Array<out TestableStatic<T>>): Boolean {
        val i = items.i

        var w = 0

        var fI = i

        sections.forEach { section ->
            sI = items.i

            val test = section test items

            fI = items.i

            if (test && w < items.i) w = items.i

            items.i = i
        }


        val test = when {
            w == 0 -> {
                items.i = fI
                false
            }
            w > 0 -> {
                items.i = w
                true
            }
            else -> false
        }


        // if (test) collect(items, sI, name)

        return test
    }

}





