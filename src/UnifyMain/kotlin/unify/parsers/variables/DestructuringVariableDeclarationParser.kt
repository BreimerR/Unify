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

// TODO wrong syntax supported var [var name = 12] = []
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
                        Section(
                            OptionalSection(
                                MutableStateParser()
                            ),
                            SimpleVariableParser()
                        ),
                        Coma
                    ),
                    RBrace
                ),
                Section(
                    LSBracket,
                    RepetitiveBySection(
                        Section(
                            OptionalSection(
                                MutableStateParser()
                            ),
                            SimpleVariableParser()
                        ),
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