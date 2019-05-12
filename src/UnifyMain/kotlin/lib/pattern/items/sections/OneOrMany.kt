package lib.pattern.items.sections

import lib.patternMatcher.items.Item
import lib.pattern.patterns.Pattern


// Regex is a matcher of character that returns array of caracters
class OneOrMany<T>(vararg sections: Item<T>) : Pattern<T>(*sections)