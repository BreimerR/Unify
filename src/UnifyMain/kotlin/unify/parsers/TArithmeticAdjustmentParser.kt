package unify.parsers

import lib.matcher.TestableStatic

class TArithmeticAdjustmentParser : ArithmeticAdjustmentParser() {
    override var sections: Array<out TestableStatic<String>>
        get() = arrayOf(
            *super.sections,
            TerminatorParser()
        )
        set(value) {
        }
}