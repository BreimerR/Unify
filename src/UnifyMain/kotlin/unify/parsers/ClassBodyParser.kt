package unify.parsers

import language.parsers.ParserStatic
import language.sections.AlternativeSection
import language.sections.ZeroOrMany
import unify.parsers.functions.ActionParser
import unify.parsers.functions.MethodParser
import unify.parsers.objects.ClassParser
import unify.parsers.objects.EnumParser
import unify.tokens.characters.LBrace
import unify.tokens.characters.RBrace

class ClassBodyParser : ParserStatic() {
    override val sections by lazy {
        arrayOf(
                LBrace,
                ZeroOrMany(
                        AlternativeSection(
                                VariableDeclarationParser(),
                                EnumParser(),
                                ClassParser(),
                                ActionParser(),
                                MethodParser()
                        )
                ),
                RBrace
        )
    }
}
