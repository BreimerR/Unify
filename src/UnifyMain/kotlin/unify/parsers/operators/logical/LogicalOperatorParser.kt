package unify.parsers.operators.logical

import language.parsers.ParserStatic
import language.sections.AlternativeSection
import language.sections.OptionalSection
import language.sections.Section
import unify.tokens.characters.Ampersand
import unify.tokens.characters.Exclamation
import unify.tokens.characters.Pipe


class LogicalOperatorParser : ParserStatic(
        OptionalSection(Exclamation),
        AlternativeSection(
                // &&
                Section(Ampersand, Ampersand),
                // ||
                Section(Pipe, Pipe),
                // !
                Section(Exclamation)
        )
)