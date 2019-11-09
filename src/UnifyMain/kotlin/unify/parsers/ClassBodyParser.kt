package unify.parsers

import language.parsers.ParserStatic
import language.sections.*
import lib.matcher.TestableStatic
import lib.matcher.sections.SingleInstanceSection
import unify.parsers.comments.CommentsParser
import unify.parsers.functions.FuncExceptionParser
import unify.parsers.functions.AccessModifiersParser
import unify.parsers.functions.ActionParser
import unify.parsers.functions.FunctionItemsParser
import unify.parsers.functions.MethodParser
import unify.parsers.objects.ClassParser
import unify.parsers.objects.EnumParser
import unify.tokens.characters.LBrace
import unify.tokens.characters.RBrace
import unify.tokens.strings.IdentifierStatic

class ClassBodyParser : ParserStatic() {
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
                                        OverridesParser(),
                                        AccessModifiersParser(),
                                        AlternativeSection(
                                                TerminatedVariableDeclarationParser(),
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
