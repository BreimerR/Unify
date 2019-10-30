package language.parsers

import language.sections.Section
import lib.matcher.TestableStatic

open class ParserStatic(vararg sections: TestableStatic<String>, considerSeparation: Boolean = false) : Section(*sections, considerSeparation = considerSeparation)
