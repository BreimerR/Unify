package unify.parsers.expressions

import language.parsers.ParserStatic
import language.sections.AlternativeSection
import language.sections.OptionalSection
import language.sections.RepetitiveBySection
import language.sections.Section
import unify.parsers.literals.ReferenceParser
import unify.tokens.characters.Coma
import unify.tokens.characters.Dot
import unify.tokens.characters.LBracket
import unify.tokens.characters.RBracket
import unify.tokens.strings.Identifier


class FunctionCallParser : ParserStatic(
        AlternativeSection(
                AlternativeSection(
                        Section(
                                Section(
                                        ReferenceParser(),
                                        LBracket,
                                        OptionalSection(
                                                RepetitiveBySection(
                                                        ExpressionParser(),
                                                        Coma
                                                )
                                        ),
                                        RBracket
                                ),
                                OptionalSection(
                                        Dot,
                                        RepetitiveBySection(
                                                AlternativeSection(
                                                        Section(
                                                                ReferenceParser(),
                                                                LBracket,
                                                                OptionalSection(
                                                                        RepetitiveBySection(
                                                                                ExpressionParser(),
                                                                                Coma
                                                                        )
                                                                ),
                                                                RBracket
                                                        ),
                                                        Identifier
                                                ),
                                                Dot
                                        )
                                )
                        ),
                        Section(
                                ReferenceParser(),
                                LBracket,
                                OptionalSection(
                                        RepetitiveBySection(
                                                ExpressionParser(),
                                                Coma
                                        )
                                ),
                                RBracket
                        )
                ),
                Section(
                        ReferenceParser(),
                        ReferenceParser(),
                        ExpressionParser()
                )
        )
) {
    override val TAG: String = "FunctionCallParser"
}
