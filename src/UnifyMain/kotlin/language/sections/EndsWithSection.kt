package language.sections

import lib.matcher.TestableStatic
import unify.tokens.tokens.EOF

class EndsWithSection(vararg sections: TestableStatic<String>, considerSeparation: Boolean = false) : Section() {
    override val sections by lazy {
        val end = Section(*sections, considerSeparation = considerSeparation)

        arrayOf(
                ZeroOrMany(
                        NotSection(
                                AlternativeSection(
                                        EOF,
                                        end
                                )
                        ),
                        considerSeparation = considerSeparation
                ),
                end
        )
    }
}