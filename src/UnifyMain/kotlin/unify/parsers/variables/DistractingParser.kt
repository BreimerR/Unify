package unify.parsers.variables

import language.parsers.ParserStatic
import language.sections.AlternativeSection

class DistractingParser : ParserStatic(
        AlternativeSection(
                ObjectDistractingParser(),
                ArrayDistractingParser()
        )
) {
    override val TAG = "DistractingParser"
}