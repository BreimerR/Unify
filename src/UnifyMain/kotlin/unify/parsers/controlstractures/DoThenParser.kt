package unify.parsers.controlstractures

import language.parsers.ParserStatic
import language.sections.OptionalSection
import lib.matcher.TestableStatic
import unify.parsers.ArgumentsParser
import unify.parsers.TypeDeclarationParser
import unify.parsers.functions.FunctionBodyParser
import unify.parsers.literals.ReferenceParser
import unify.tokens.characters.*
import unify.tokens.strings.KeywordStatic

class DoThenParser : ParserStatic() {
    override var sections: Array<out TestableStatic<String>>
        get() {

            val secs = arrayOf(
                    KeywordStatic("do"),
                    OptionalSection(
                            LThan,
                            TypeDeclarationParser(),
                            GThan
                    ),
                    OptionalSection(
                            LBracket,
                            ReferenceParser(),
                            OptionalSection(
                                    Coma,
                                    ReferenceParser()
                            ),
                            RBracket
                    ),
                    FunctionBodyParser(),
                    KeywordStatic("then"),
                    OptionalSection(
                            ArgumentsParser()
                    ),
                    FunctionBodyParser()
            )

            return secs
        }
        set(value) {}
}