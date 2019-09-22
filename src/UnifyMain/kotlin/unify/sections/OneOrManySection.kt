package unify.sections

import lib.matcher.TestableStatic

class OneOrManySection(vararg sections: TestableStatic) : RepetitiveSection(*sections, minCount = 1)