package lib.matcher.sections


import lib.matcher.TestableStatic
import lib.matcher.items.ItemsStatic.Class as ItemsClass

abstract class ZeroOrManySectionStatic<T> : RepetitiveSectionStatic<T>() {

    abstract fun invoke(vararg items: TestableStatic.Class<T>, name: String?, maxCount: Int = this.maxCount): Class<T>

    abstract override fun invoke(vararg items: TestableStatic.Class<T>, name: String?): Class<T>

    abstract fun invoke(item: TestableStatic.Class<T>, name: String?, maxCount: Int = this.maxCount): Class<T>

    abstract override operator fun invoke(item: TestableStatic.Class<T>, name: String?, minCount: Int, maxCount: Int): Class<T>

    abstract override operator fun invoke(vararg item: TestableStatic.Class<T>, name: String?, minCount: Int, maxCount: Int): Class<T>


    abstract class Class<T>(vararg section: TestableStatic.Class<T>, name: String?, maxCount: Int, self: ZeroOrManySectionStatic<T>) :
            RepetitiveSectionStatic.Class<T>(*section, name = name, minCount = 0, maxCount = maxCount, self = self) {

        override fun test(items: ItemsClass<T>): Boolean {
            val i = items.i

            if (!super.test(items)) items.i = i

            return true
        }
    }
}