package lib.matcher.sections


import lib.matcher.TestableStatic

class ZeroOrManySection<T> : OptionalSection<T> {

    constructor(vararg section: TestableStatic<T>)
            : super(OneOrManySection(*section))

    constructor(vararg sections: TestableStatic<T>, name: String? = null, maxCount: Int)
            : super(OneOrManySection(*sections, name = name, minCount = 0, maxCount = maxCount))

}