package unify.parsers.variables

import language.parsers.ParserStatic
import language.sections.AlternativeSection
import language.sections.Section
import lib.matcher.TestableStatic

class SimpleVariableParser : ParserStatic() {

    override val TAG = "SimpleVariableParser"

    override var sections: Array<out TestableStatic<String>>
        get() = arrayOf(
                AlternativeSection(
                        Section(
                                VariableStartParser(),
                                DistractingParser()
                        ),
                        VariableStartParser(),
                        DistractingParser()
                ),
                VariableEndParser()
        )
        set(value) {

        }
}


