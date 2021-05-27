package unify.parsers

import language.parsers.ParserStatic
import language.sections.AlternativeSection
import language.sections.OptionalSection
import language.sections.RepetitiveBySection
import language.sections.Section
import unify.parsers.variables.SimpleVariableParser
import unify.parsers.variables.VariableStartParser
import unify.tokens.characters.*

val dots = arrayOf(Dot, Dot, Dot)

class ParametersParser : ParserStatic(
    LBracket,
    OptionalSection(
        AlternativeSection(
            Section(
                Section(
                    OptionalSection(
                        MutableStateParser()
                    ),
                    Dot, Dot, Dot,
                    SimpleVariableParser(),
                ),
                Coma,
                RepetitiveBySection(
                    Coma,
                    ParameterParser(),
                ),
                Coma,
                Section(
                    OptionalSection(
                        MutableStateParser()
                    ),
                    Dot, Dot, Dot,
                    SimpleVariableParser(),
                ),
            ),
            Section(
                Section(
                    OptionalSection(
                        MutableStateParser()
                    ),
                    Dot, Dot, Dot,
                    SimpleVariableParser(),
                ),
                Coma,
                RepetitiveBySection(
                    Coma,
                    ParameterParser(),
                )
            ),
            Section(
                RepetitiveBySection(
                    Coma,
                    ParameterParser(),
                ),
                Coma,
                Section(
                    OptionalSection(
                        MutableStateParser()
                    ),
                    Dot, Dot, Dot,
                    SimpleVariableParser(),
                )
            ),
            Section(
                OptionalSection(
                    MutableStateParser()
                ),
                Dot, Dot, Dot,
                VariableStartParser()
            ),
            RepetitiveBySection(
                Coma,
                ParameterParser(),
            )
        )
    ),
    RBracket
)