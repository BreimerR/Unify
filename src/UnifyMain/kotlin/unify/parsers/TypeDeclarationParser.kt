package unify.parsers

import language.parsers.Parser
import lib.matcher.sections.OneOrManySection
import lib.matcher.sections.OptionalSection
import lib.matcher.sections.RepetitiveBySection
import unify.tokens.characters.Coma
import unify.tokens.characters.GThan
import unify.tokens.characters.LThan
import unify.tokens.strings.Identifier

class TypeDeclarationParser :
        Parser() {

    override val considerSpaces = false
    // sections not definable via the constructor as self is being recreated
    override val sections by lazy {
        arrayOf(
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
    }
}