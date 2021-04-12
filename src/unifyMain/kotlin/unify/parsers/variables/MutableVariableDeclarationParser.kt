package unify.parsers.variables

import language.parsers.ParserStatic
import lib.matcher.TestableStatic
import unify.parsers.MutableStateParser

class MutableVariableDeclarationParser : ParserStatic() {
    override val TAG = "MutableVariableDeclarationParser"

    override var sections: Array<out TestableStatic<String>>
        get() = arrayOf(
                MutableStateParser(),
                SimpleVariableParser()
        )
        set(value) {

        }
}