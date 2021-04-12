package unify.parsers.objects

import language.parsers.ParserStatic
import language.sections.AlternativeSection
import language.sections.Section
import language.sections.ZeroOrMany
import lib.matcher.TestableStatic
import unify.parsers.variables.TVariableDeclarationParser
import unify.parsers.expressions.FunctionStartParser
import unify.parsers.functions.AccessModifiersParser
import unify.tokens.characters.LBrace
import unify.tokens.characters.RBrace
import unify.tokens.strings.Identifier

class InterfaceBodyParser : ParserStatic() {
    override var sections: Array<out TestableStatic<String>>
        get() = arrayOf(
            LBrace,
            ZeroOrMany(
                AlternativeSection(
                    Section(
                        AccessModifiersParser(),
                        AlternativeSection(
                            TVariableDeclarationParser(),
                            FunctionStartParser(),
                        )
                    ),
                    InterfaceParser()
                )
            ),
            RBrace
        )
        set(value) {}
}
