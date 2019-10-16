package unify.parsers

import language.parsers.Parser
import language.sections.Section
import language.sections.AlternativeSection
import language.sections.RepetitiveBySection
import unify.tokens.characters.Coma
import unify.tokens.characters.LSBracket
import unify.tokens.characters.RSBracket

class ArrayTypeDeclarationParser : Parser(
        TypeDeclarationParser(),
        Section(
                LSBracket,
                AlternativeSection(
                        // check for size declaration
                        // TODO can not be a Float has to be integer
                        NumberParser(),
                        // use types as the size of the array and the values
                        // assignable for each position in the array
                        RepetitiveBySection(
                                TypeDeclarationParser(),
                                Coma
                        )
                ),
                RSBracket
        ),
        name = "ARRAY_TYPE_DECLARATION"
)