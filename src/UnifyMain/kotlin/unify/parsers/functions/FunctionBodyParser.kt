package unify.parsers.functions

import language.parsers.ParserStatic
import language.sections.AlternativeSection
import lib.matcher.TestableStatic

class FunctionBodyParser : ParserStatic() {
    override val TAG = "FunctionBodyParser"

    override var sections: Array<out TestableStatic<String>>
        get() = arrayOf(
                AlternativeSection(
                        FunctionItemsParser(),
                        ReturnFuncBodyParser(),
                        ActFuncBodyParser()
                )
        )
        set(value) {}
}
