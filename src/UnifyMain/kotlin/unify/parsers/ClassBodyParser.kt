package unify.parsers

import language.parsers.ParserStatic
import language.sections.AlternativeSection
import language.sections.OptionalSection
import language.sections.Section
import language.sections.ZeroOrMany
import lib.matcher.TestableStatic
import lib.matcher.sections.SingleInstanceSection
import unify.parsers.comments.CommentsParser
import unify.parsers.functions.*
import unify.parsers.objects.ClassParser
import unify.parsers.objects.EnumParser
import unify.parsers.variables.TVariableDeclarationParser
import unify.tokens.characters.LBrace
import unify.tokens.characters.RBrace
import unify.tokens.strings.IdentifierStatic

class ClassBodyParser : ParserStatic() {

    override val TAG = "ClassBodyParser"

    override var sections: Array<out TestableStatic<String>>
        get() = arrayOf(
                LBrace,
                ZeroOrMany(
                        AlternativeSection(
                                SingleInstanceSection(
                                        IdentifierStatic("init"),
                                        FuncExceptionParser(),
                                        FunctionItemsParser()
                                ),
                                Section(
                                        OptionalSection(
                                                OverridesParser()
                                        ),
                                        AccessModifiersParser(),
                                        AlternativeSection(
                                                TVariableDeclarationParser(),
                                                ActionParser(),
                                                MethodParser()
                                        )
                                ),
                                ClassParser(),
                                EnumParser(),
                                CommentsParser()
                        )
                ),
                RBrace
        )
        set(value) {}
}
