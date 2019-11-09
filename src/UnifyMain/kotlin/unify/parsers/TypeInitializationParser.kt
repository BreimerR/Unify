package unify.parsers

import language.parsers.ParserStatic
import language.sections.OptionalSection
import lib.matcher.TestableStatic

class TypeInitializationParser : ParserStatic() {

    override var sections: Array<out TestableStatic<String>>
        get() = arrayOf(
                TypeDeclarationParser(),
                OptionalSection(
                        ArrayBodyDeclarationParser()
                )
        )
        set(value) {}
}
