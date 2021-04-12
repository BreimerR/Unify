package unify.parsers.variables

import language.parsers.ParserStatic
import language.sections.AlternativeSection
import lib.matcher.TestableStatic

class VariableDeclarationParser : ParserStatic() {
    override val TAG = "VariableDeclaration"

    override var sections: Array<out TestableStatic<String>>
        get() = arrayOf(
                AlternativeSection(
                        MutableVariableDeclarationParser(),
                        DestructuringVariableDeclarationParser()
                )
        )
        set(value) {}
}


