package unify.parsers

import language.parsers.ParserStatic
import language.sections.OptionalSection
import language.sections.RepetitiveBySection
import language.sections.RepetitiveBySectionReMaster
import lib.matcher.TestableStatic
import unify.parsers.literals.ReferenceParser
import unify.tokens.characters.Coma
import unify.tokens.characters.GThan
import unify.tokens.characters.LThan

class TypeDeclarationParser : ParserStatic() {

    override var sections: Array<out TestableStatic<String>>
        get() {
            return arrayOf(
                ReferenceParser(),
                OptionalSection(
                    LThan,
                    RepetitiveBySectionReMaster(
                        Coma,
                        TypeDeclarationParser()
                    ),
                    GThan
                )
            )
        }
        set(value) {}


    override val TAG = "TypeDeclarationParser"
}