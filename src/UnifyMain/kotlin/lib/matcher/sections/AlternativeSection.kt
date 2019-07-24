package lib.matcher.sections


import lib.matcher.TestableStatic
import lib.matcher.items.ItemsStatic.Class as ItemsClass

abstract class AlternativeSectionStatic<T> : SectionStatic<T>() {

    abstract class Class<I>(
            vararg items: TestableStatic.Class<I>,
            override val name: String? = null,
            self: AlternativeSectionStatic<I>) :
            SectionStatic.Class<I>(*items, name = name, self = self) {

        // we dont want to find the first match but the best case match
        override infix fun test(items: ItemsClass<I>): Boolean {
            return test(items, sections)
        }

        protected fun test(items: ItemsClass<I>, sections: Array<out TestableStatic.Class<I>>): Boolean {
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


            if (test) collect(items, sI, name)

            return test
        }
    }
}





