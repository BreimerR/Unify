package language


import lib.matcher.MatcherStatic
import lib.matcher.sections.SectionStatic
import language.scopes.Scope
import language.ast.TokensStatic.Class as TokensClass


// TODO look into organization once this makes proper sense
// at one point or the other just where it will start to work right


abstract class LanguageStatic(vararg parsers: SectionStatic<String>) : MatcherStatic<String>(
        *parsers
) {
    abstract val scope: Scope

    abstract val tokens: TokensClass

    fun test(): Boolean {
        return test(tokens)
    }

}


class Lang(matcher: LanguageStatic) : MatcherStatic<String>()