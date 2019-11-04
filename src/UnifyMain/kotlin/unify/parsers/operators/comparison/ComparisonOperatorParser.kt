package unify.parsers.operators.comparison

import language.parsers.ParserStatic
import language.sections.AlternativeSection
import language.sections.Section
import unify.tokens.characters.Equals
import unify.tokens.characters.Exclamation
import unify.tokens.characters.GThan
import unify.tokens.characters.LThan

class ComparisonOperatorParser : ParserStatic(
        AlternativeSection(
                // !=
                Section(Exclamation, Equals, considerSeparation = true),
                //  ==
                Section(Equals, Equals, considerSeparation = true),
                // <=
                Section(LThan, Equals, considerSeparation = true),
                // >=
                Section(GThan, Equals, considerSeparation = true),
                // <
                Section(LThan),
                // >
                Section(GThan)
        )
)