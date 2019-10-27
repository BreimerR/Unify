package language


import lib.matcher.MatcherStatic
import language.parsers.ParserStatic
import language.ast.TokensStatic.Class as TokensClass


// TODO look into organization once this makes proper sense
//  at one point or the other just where it will start to work right


abstract class LanguageStatic : MatcherStatic<String>() {

    abstract class Class(vararg  sections: ParserStatic) : MatcherStatic.Class<String>(*sections) {
        abstract val tokens: TokensClass
    }

}


