package language.sections

import lib.matcher.TestableStatic

class ZeroOrManySection : OptionalSection {

    constructor(vararg section: TestableStatic<String>, considerSpaces: Boolean = false, name: String? = null)
            :
            super(
                    RepetitiveSection(
                            *section,
                            minCount = 1,
                            considerSpaces = considerSpaces
                    ),
                    considerSpaces = considerSpaces,
                    name = name
            )

    constructor(vararg sections: TestableStatic<String>, considerSpaces: Boolean = false, name: String? = null, maxCount: Int)
            :
            super(
                    RepetitiveSection(
                            *sections,
                            minCount = 1,
                            maxCount = maxCount,
                            considerSpaces = considerSpaces
                    ),
                    considerSpaces = considerSpaces,
                    name = name
            )
}





