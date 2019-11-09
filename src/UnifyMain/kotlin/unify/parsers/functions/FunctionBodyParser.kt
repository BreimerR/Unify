package unify.parsers.functions

import language.parsers.AlternativeParser
import lib.matcher.TestableStatic

class FunctionBodyParser : AlternativeParser() {
    override var sections: Array<out TestableStatic<String>>
        get() = arrayOf(
                FunctionItemsParser(),
                ReturnFuncBodyParser(),
                ActFuncBodyParser()
        )
        set(value) {}
}
