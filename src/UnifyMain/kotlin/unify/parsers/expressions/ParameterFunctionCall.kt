package unify.parsers.expressions

import language.parsers.ParserStatic
import language.sections.OptionalSection
import language.sections.RepetitiveBySectionReMaster
import lib.matcher.TestableStatic
import unify.parsers.literals.ReferenceParser
import unify.tokens.characters.Coma
import unify.tokens.characters.LBracket
import unify.tokens.characters.RBracket
import unify.tokens.strings.Identifier

class ParameterFunctionCall : ParserStatic() {
        override var sections: Array<out TestableStatic<String>>
            get() = arrayOf(
                    ReferenceParser(),
                    LBracket,
                    OptionalSection(
                            RepetitiveBySectionReMaster(
                                Coma,
                                Identifier
                            )
                    ),
                    RBracket
            )
            set(value) {}
    }