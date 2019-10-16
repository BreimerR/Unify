package unify.parsers

import language.parsers.Parser
import language.sections.RepetitiveBySection
import unify.tokens.characters.Coma

class ArgumentsArrayParser : Parser(
        RepetitiveBySection(
                // simple argument
                // type declaration argument name
                /** TODO
                 * typeDeclaration mutabilityState argument
                 * */
                /** TODO
                 * typeDeclaration mutabilityState argument
                 * */

                ArgumentParser(),
                Coma,
                considerSpaces = false
        ),
        name = "ARGUMENTS_LIST"
) {
    override val considerSpaces = false
}