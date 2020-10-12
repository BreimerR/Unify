package unify.parsers

import language.parsers.ParserStatic
import language.sections.OptionalSection
import language.sections.RepetitiveBySection
import language.sections.RepetitiveBySectionReMaster
import unify.tokens.characters.Coma
import unify.tokens.characters.LBracket
import unify.tokens.characters.RBracket

/**TODO
 * The code does not
 * cater for fixed param passing
 * making default setters to have
 * a few deficits i.e can not have a default setter
 * for the = sign
 * */
class ArgumentsParser(argsCount: Int? = null) : ParserStatic(
        LBracket,
        OptionalSection(
                RepetitiveBySectionReMaster(
                        Coma,
                        ArgumentParser(),
                )
        ),
        RBracket
)