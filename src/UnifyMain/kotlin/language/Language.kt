package language


import language.parsers.ParserStatic
import language.sections.AlternativeSection
import language.sections.ZeroOrMany
import lib.collections.array.pop
import lib.collections.array.last
import lib.collections.array.get
import lib.matcher.MatcherStatic
import language.ast.TokensStatic.Class as TokensClass


// TODO look into organization once this makes proper sense
//  at one point or the other just where it will start to work right


abstract class LanguageStatic(vararg parsers: ParserStatic) : MatcherStatic<String>(
        ZeroOrMany(
                AlternativeSection(
                        *parsers[0..parsers.size - 2].toTypedArray()
                )
        ),
        parsers.last
) {

    abstract val tokens: TokensClass

    fun test(): Boolean {
        return super.test(tokens)
    }

    fun parse() {

    }

}




