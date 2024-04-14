package unify.parsers.variables

import language.parsers.ParserStatic
import language.sections.OptionalSection
import lazy.mutableLazy
import lib.matcher.TestableStatic

class SimpleVariableParser : ParserStatic() {

    override val TAG = "SimpleVariableParser"

    override var sections: Array<out TestableStatic<String>> by mutableLazy {
        arrayOf(
            VariableStartParser(),
            OptionalSection(
                VariableEndParser()
            )
        )
    }

}
