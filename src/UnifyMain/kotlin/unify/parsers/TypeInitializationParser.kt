package unify.parsers

import language.parsers.ParserStatic
import language.sections.OptionalSection

class TypeInitializationParser : ParserStatic() {

    override val sections by lazy {
        arrayOf(
                TypeDeclarationParser(),
                OptionalSection(
                        ArrayBodyDeclarationParser()
                )
        )
    }
}
