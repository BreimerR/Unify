package unify.parsers

import language.parsers.ParserStatic
import language.sections.RepetitiveBySection
import unify.tokens.characters.Coma
import unify.tokens.strings.Identifier

class FunctionParser : ParserStatic(
        RepetitiveBySection(
                Identifier, Coma
        ),
        considerSeparation = false
)