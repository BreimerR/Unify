package unify.parsers.variables

import language.parsers.ParserStatic
import language.sections.AlternativeSection
import lib.matcher.TestableStatic

class DestructuringParser : ParserStatic() {
    override val TAG = "DistractingParser"

    override var sections: Array<out TestableStatic<String>>
        get() = arrayOf(
                AlternativeSection(
                        ObjectDestructuringParser(),
                        ArrayDestructuringParser()
                )
        )
        set(value) {}
}


