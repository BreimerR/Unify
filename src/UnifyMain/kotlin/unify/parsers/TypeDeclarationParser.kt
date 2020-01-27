package unify.parsers

import language.parsers.ParserStatic
import language.sections.OptionalSection
import language.sections.RepetitiveBySection
import lib.matcher.TestableStatic
import unify.tokens.characters.Coma
import unify.tokens.characters.GThan
import unify.tokens.characters.LThan
import unify.tokens.strings.Identifier

class TypeDeclarationParser : ParserStatic() {
    override var sections: Array<out TestableStatic<String>>
        get() = arrayOf(
                Identifier,
                OptionalSection(
                        LThan,
                        RepetitiveBySection(
                                TypeDeclarationParser(),
                                Coma
                        ),
                        GThan
                )
        )
        set(value) {}
}