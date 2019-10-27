package language.sections

import lib.matcher.TestableStatic

class ZeroOrManyStatic<T> : RepetitiveSectionStatic<T>() {

    class Class<T>(vararg sections: TestableStatic.Class<T>) : RepetitiveSectionStatic.Class<T>(*sections, minCount = 0, maxCount = RepetitiveSection.maxCount) {
        override val self by lazy {
            ZeroOrMany
        }
    }
}


val ZeroOrMany = ZeroOrManyStatic<String>()