package unify.parsers.variables

import language.parsers.ParserStatic
import language.sections.*
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
                    RepetitiveBySectionReMaster(
                        Coma,
                        Section(
                            OptionalSection(
                                MutableStateParser()
                            ),
                            SimpleVariableParser()
                        )
                    ),
                    RBrace
                ),
                Section(
                    LSBracket,
                    RepetitiveBySectionReMaster(
                        Coma,
                        Section(
                            OptionalSection(
                                MutableStateParser()
                            ),
                            SimpleVariableParser()
                        )
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