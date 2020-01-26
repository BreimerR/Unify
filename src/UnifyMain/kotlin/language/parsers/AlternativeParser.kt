package language.parsers

import language.sections.AlternativeSection
import lib.matcher.TestableStatic


open class AlternativeParser(vararg sections: TestableStatic<String>, considerSeparation: Boolean = false) : AlternativeSection(*sections, considerSeparation = considerSeparation)