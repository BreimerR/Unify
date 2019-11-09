package language


import language.parsers.ParserStatic
import language.sections.AlternativeSection
import language.sections.Section
import language.sections.ZeroOrMany
import lib.collections.array.pop
import lib.collections.array.last
import lib.collections.array.get
import lib.matcher.MatcherStatic
import lib.matcher.items.ItemsStatic
import lib.matcher.sections.OptionalSectionStatic
import lib.matcher.sections.RepetitiveSectionStatic
import lib.matcher.sections.SectionStatic
import unify.parsers.TerminatedVariableDeclarationParser
import unify.parsers.comments.CommentsParser
import unify.parsers.expressions.TAssignmentExpressionParser
import unify.parsers.functions.FunctionParser
import unify.parsers.objects.ClassParser
import unify.parsers.objects.EnumParser
import language.ast.TokensStatic.Class as TokensClass


// TODO look into organization once this makes proper sense
//  at one point or the other just where it will start to work right


abstract class LanguageStatic(vararg parsers: SectionStatic<String>) : MatcherStatic<String>(
        *parsers
) {

    abstract val tokens: TokensClass

    fun test(): Boolean {
        return test(tokens)
    }

}




