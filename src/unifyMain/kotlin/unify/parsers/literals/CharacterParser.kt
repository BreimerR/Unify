package unify.parsers.literals

import language.parsers.ParserStatic
import language.sections.AlternativeSection
import language.sections.NotSection
import unify.tokens.characters.BSlash
import unify.tokens.characters.SQuotes
import unify.tokens.strings.Character
import unify.tokens.strings.Identifier

// TODO this might break parser logic as it requires a single character and a single character is a whole token on it's own
// this is not good news at all
// this might not be correct
class CharacterParser : ParserStatic(
        SQuotes,
        AlternativeSection(
                EScapeCharacter(SQuotes, considerSpaces = true),
                EScapeCharacter(BSlash, considerSpaces = true),
                Character,
                NotSection(
                        AlternativeSection(
                                Identifier,
                                NumberParser(),
                                SQuotes
                        )
                ),
                considerSeparation = true
        ),
        SQuotes
)

