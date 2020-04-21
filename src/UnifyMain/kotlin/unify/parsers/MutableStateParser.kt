package unify.parsers

import language.parsers.ParserStatic
import language.sections.AlternativeSection
import language.sections.OptionalSection
import language.sections.Section
import unify.tokens.strings.KeywordStatic

// var read write
// val read only
// const runtime value
class MutableStateParser : ParserStatic(
        AlternativeSection(
                KeywordStatic("var"),
                Section(
                        // define if the var or val is static
                        OptionalSection(
                                // if true this value should be available
                                KeywordStatic("const"),
                                name = "VAL_CONSTANTS"
                        ),
                        KeywordStatic("val")
                )

        ),
        name = "VAR_MUTABILITY"
)