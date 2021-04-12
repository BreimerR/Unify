package unify.parsers.expressions

import language.parsers.ParserStatic
import language.sections.AlternativeSection
import unify.parsers.TypeDeclarationParser
import unify.parsers.literals.ReferenceParser

class InfixFunctionCallParser : ParserStatic(
    ReferenceParser(),
    ReferenceParser(),
    // TODO this requires knowledge of the IR code
    // as you can not describe this symbolic and
    // come out with a reasonable
    // conclusion of what it should be
    AlternativeSection(
        // TODO problem might have been solved***
        // this is a problem
        // Alternative<Sleep>
        // can be reference lessThan Sleep and > is left hanging
        // parsing type declaration
        // sleep > 10
        // sleep is a TypeDeclaration and > 10 is left hanging
        TypeDeclarationParser(),
        ExpressionParser()
    )
)