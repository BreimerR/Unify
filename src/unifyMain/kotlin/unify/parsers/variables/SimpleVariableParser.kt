package unify.parsers.variables

import language.parsers.ParserStatic
import language.sections.OptionalSection
import lib.matcher.TestableStatic

class SimpleVariableParser : ParserStatic() {

    override val TAG = "SimpleVariableParser"

    override var sections: Array<out TestableStatic<String>>
        get() = arrayOf(
                VariableStartParser(),
                OptionalSection(
                        VariableEndParser()
                )
        )
        set(value) {

        }
}


