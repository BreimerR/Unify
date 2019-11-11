package unify.parsers.objects

import language.parsers.ParserStatic
import language.sections.OptionalSection
import language.sections.RepetitiveBySection
import language.sections.Section
import lib.matcher.TestableStatic
import unify.parsers.GenericTypeParser
import unify.parsers.TypeDeclarationParser
import unify.tokens.characters.Colon
import unify.tokens.characters.Coma
import unify.tokens.strings.Identifier
import unify.tokens.strings.IdentifierStatic
import unify.tokens.strings.KeywordStatic

class InterfaceParser : ParserStatic() {
    override var sections: Array<out TestableStatic<String>>
        get() = arrayOf(
                IdentifierStatic("interface"),
                Section(Identifier),
                OptionalSection(
                        GenericTypeParser()
                ),
                OptionalSection(
                        Colon,
                        RepetitiveBySection(
                                TypeDeclarationParser(),
                                Coma
                        )
                ),
                InterfaceBodyParser()
        )
        set(value) {}
}