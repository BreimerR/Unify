package unify.parsers.variables

import language.parsers.ParserStatic
import language.sections.RepetitiveBySection
import lib.matcher.TestableStatic
import unify.tokens.characters.Coma

class DestructuringCenterParser : ParserStatic() {

    override val TAG = "DestructuringCenterParser"

    override var sections: Array<out TestableStatic<String>>
        get() = arrayOf(
                RepetitiveBySection(
                        OptionalMutabilityVariableDeclarationParser(),
                        Coma
                )
        )
        set(value) {}
}