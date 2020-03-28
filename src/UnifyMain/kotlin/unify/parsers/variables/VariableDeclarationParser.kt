package unify.parsers.variables

import System
import language.parsers.ParserStatic
import language.sections.OptionalSection
import lib.matcher.items.ItemsStatic
import unify.ast.TokensStatic
import unify.parsers.MutableStateParser
import unify.tokens.strings.KeywordStatic

class VariableDeclarationParser : ParserStatic(
        // define if the var or val is static
        OptionalSection(
                // if true this value should be available
                KeywordStatic("const")
        ),
        MutableStateParser(),
        SimpleVariableParser()
) {
    override fun test(items: ItemsStatic.Class<String>): Boolean {
        val test = super.test(items)

        items as TokensStatic.Class

        if (System.DEBUG) println("VariableDeclaration Returns $test \t token =  ${items.token}  \t token.value = ${items.token?.value}")

        return test
    }
}