package unify.parsers

import language.parsers.Parser
import lib.matcher.sections.RepetitiveBySection
import lib.matcher.sections.Section
import unify.tokens.characters.Coma

class ArgumentsArrayParser : Parser(
        RepetitiveBySection(
                // simple argument
                // type declaration argument name
                /** TODO
                 * typeDeclaration mutabilityState argument
                 * */

                ArgumentParser(),
                Coma
        ),
        name = "ARGUMENTS_LIST"
) {
    override val considerSpaces = false
}