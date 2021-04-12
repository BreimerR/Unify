package unify.parsers.expressions

import language.parsers.ParserStatic
import language.sections.RepetitiveBySection
import unify.tokens.characters.Coma

class ArgumentsParser : ParserStatic(
    RepetitiveBySection(
        Coma,
        ArgumentParser()
    )
)

