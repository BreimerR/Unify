package language


import language.scopes.Scope
import lib.matcher.MatcherStatic
import lib.matcher.sections.SectionStatic
import language.ast.TokensStatic.Class as TokensClass


// TODO look into organization once this makes proper sense
// at one point or the other just where it will start to work right


abstract class Language(vararg parsers: SectionStatic<String>) : MatcherStatic<String>(
        *parsers
) {
    abstract val scope: Scope

    abstract val tokens: TokensClass

    fun test(): Boolean = test(tokens)

    class Class(matcher: Language) : MatcherStatic<String>()

}


