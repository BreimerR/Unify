package unify.parsers.variables

import language.parsers.ParserStatic
import language.sections.AlternativeSection
import language.sections.OptionalSection
import language.sections.RepetitiveSection
import language.sections.ZeroOrMany
import unify.parsers.MutableStateParser
import unify.parsers.TerminatorParser
import unify.tokens.characters.Coma
import unify.tokens.characters.NewLine
import unify.tokens.characters.Space
import unify.tokens.characters.Tab
import unify.tokens.strings.KeywordStatic

class MultiVariableDeclarationParser : ParserStatic(
        OptionalSection(
                // if true this value should be available
                KeywordStatic("const")
        ),
        MutableStateParser(),
        SimpleVariableParser(),
        RepetitiveSection(
                ZeroOrMany(AlternativeSection(Tab, NewLine, Space, considerSeparation = true)),
                Coma,
                SimpleVariableParser(),
                minCount = 1
        ),
        TerminatorParser()
)