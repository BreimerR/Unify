package lib.matcher.sections


import lib.matcher.TestableStatic
import lib.matcher.items.ItemsStatic.Class as ItemsClass


class NotSection<T>(vararg sections: TestableStatic<T>, name: String? = null) :
        Section<T>(*sections, name = name) {

    // search algo required here to make the loop not linear exactly for performance boost
    override fun test(items: ItemsClass<T>): Boolean {
        sections.forEach {
            val i = items.i
            if (it test items) {
                items.i = i
                return false
            }
        }

        return true
    }

}






