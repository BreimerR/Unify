package language.parsers

import language.sections.Section
import language.sections.ZeroOrMany
import lib.matcher.TestableStatic
import unify.tokens.characters.NewLine
import unify.tokens.characters.Space
import unify.tokens.characters.Tab

open class ParserStatic(
        vararg sections: TestableStatic<String>,
        considerSeparation: Boolean = false,
        name: String? = null
) : Section(
        *if (considerSeparation) arrayOf(ZeroOrMany(Tab, Space, NewLine), *sections) else sections,
        considerSeparation = considerSeparation,
        name = name
)
