package unify.parsers

import language.parsers.ParserStatic
import language.sections.AlternativeSection
import language.sections.RepetitiveBySectionReMaster
import language.sections.Section
import unify.tokens.characters.Colon
import unify.tokens.characters.Coma
import unify.tokens.characters.GThan
import unify.tokens.characters.LThan
import unify.tokens.strings.Identifier

class GenericTypeParser : ParserStatic(
        LThan,
        RepetitiveBySectionReMaster(
                Coma,
                AlternativeSection(
                        Section(
                                Identifier,
                                AlternativeSection(
                                        ReferenceOperatorParser(),
                                        Colon
                                ),
                                TypeDeclarationParser()
                        ),
                        TypeDeclarationParser()
                )
        ),
        GThan
)