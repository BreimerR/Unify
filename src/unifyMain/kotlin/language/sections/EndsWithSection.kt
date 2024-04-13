package language.sections

import lib.matcher.TestableStatic
import unify.tokens.tokens.EOF

class EndsWithSection(
    private vararg var mSections: TestableStatic<String>,
    considerSeparation: Boolean = false,
    considerSpaces: Boolean = false,
    considerNewLine: Boolean = false
) : Section(
    considerSeparation = considerSeparation,
    considerSpaces = considerSpaces,
    considerNewLines = considerNewLine
) {

    override val TAG = "EndsWithSection"

    @Deprecated("Use case should be deprecated")
    private val _sections: Array<out TestableStatic<String>>
        get() {

            val end = Section(*mSections, considerSeparation = considerSeparation)

            return arrayOf(
                ZeroOrMany(
                    NotSection(
                        AlternativeSection(
                            end,
                            EOF,
                            considerSeparation = considerSeparation
                        ),
                        considerSeparation = considerSeparation
                    ),
                    considerSeparation = considerSeparation
                ),
                end
            )
        }


    override var sections: Array<out TestableStatic<String>>
        get() {

            val end = Section(*mSections, considerSeparation = considerSeparation)

            return arrayOf(
                ZeroOrMany(
                    NotSection(
                        AlternativeSection(
                            end,
                            EOF,
                            considerSeparation = considerSeparation
                        ),
                        considerSeparation = considerSeparation
                    ),
                    considerSeparation = considerSeparation
                ),
                end
            )
        }
        set(value) {}

}
