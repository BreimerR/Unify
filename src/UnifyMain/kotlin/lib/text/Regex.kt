package lib.text

import lib.pattern.items.Items
import lib.pattern.matcher.MatchResult
import lib.pattern.matcher.MatcherClass
import lib.pattern.matcher.MatcherStatic


class RegexClass(override val found: Array<MatchResult<Char>>?) : MatcherClass<Char>() {
    override fun match(items: Items<Char>): Array<out MatchResult<Char>> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun test(items: Items<Char>): Boolean {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override val self = Regex
}

class RegexStatic : MatcherStatic()

val Regex = RegexStatic()


