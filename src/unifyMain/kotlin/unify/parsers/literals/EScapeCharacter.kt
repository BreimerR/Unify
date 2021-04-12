package unify.parsers.literals

import language.parsers.ParserStatic
import language.sections.AlternativeSection
import language.sections.ZeroOrMany
import lib.matcher.TestableStatic
import unify.tokens.characters.BSlash
import unify.tokens.characters.Space
import unify.tokens.characters.Tab
import unify.tokens.tokens.TokenStatic

class EScapeCharacter(val character: TokenStatic, considerSpaces: Boolean = false) : ParserStatic(
        considerSeparation = considerSpaces
) {

    override var sections: Array<out TestableStatic<String>>
        get() = arrayOf(
                ZeroOrMany(
                        AlternativeSection(
                                Tab,
                                Space,
                                considerSeparation = true
                        ),
                        considerSeparation = true
                ),
                BSlash,
                character
        )
        set(value) {}
}