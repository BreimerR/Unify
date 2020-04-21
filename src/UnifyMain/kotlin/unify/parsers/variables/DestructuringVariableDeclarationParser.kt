package unify.parsers.variables

import language.parsers.ParserStatic
import language.sections.AlternativeSection
import language.sections.OptionalSection
import language.sections.RepetitiveBySection
import language.sections.Section
import lib.matcher.TestableStatic
import unify.parsers.MutableStateParser
import unify.parsers.TypeDeclarationParser
import unify.tokens.characters.*

class DestructuringVariableDeclarationParser : ParserStatic() {
    override var sections: Array<out TestableStatic<String>>
        get() = arrayOf(
                OptionalSection(
                        MutableStateParser()
                ),
                AlternativeSection(
                        Section(
                                LBrace,
                                RepetitiveBySection(
                                        MutableVariableDeclarationParser(),
                                        Coma
                                ),
                                RBrace
                        ),
                        Section(
                                LSBracket,
                                RepetitiveBySection(
                                        MutableVariableDeclarationParser(),
                                        Coma
                                ),
                                RSBracket
                        )
                ),
                OptionalSection(
                        Colon,
                        TypeDeclarationParser()
                ),
                VariableEndParser()
        )
        set(value) {}
}