import language.parsers.ParserStatic
import language.sections.Section
import language.sections.ZeroOrMany
import lib.cli.CLIArguments
import lib.matcher.TestableStatic
import lib.matcher.items.ItemsStatic
import unify.Unify
import unify.ast.Tokens
import unify.ast.TokensStatic
import unify.parsers.MutableStateParser
import unify.parsers.comments.CommentsParser
import unify.parsers.variables.SimpleVariableParser

import unify.parsers.variables.VariableDeclarationParser
import unify.parsers.variables.VariableStartParser
import unify.parsers.variables.VariableTypeDeclarationParser
import unify.tokens.tokens.EOF
import kotlin.test.Test
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class UnifyTest {

    private val variableDeclarationParser
        get() = VariableDeclarationParser()

    private val eofDeclarationParser
        get() = Section(EOF)


    var parser: TestableStatic<String> = Section(EOF)

    var updated = false

    var file = ""
        set(value) {
            updated = value != field
            field = value
        }

    private var filePath: String = ""
        get() = if (updated) {
            field = "src/unifyTest/unify/$file.u"
            field
        } else field

    private var _tokens: TokensStatic.Class? = null

    private val tokens: TokensStatic.Class
        get() = (if (updated) {
            _tokens = Tokens(filePath)
            updated = false
            _tokens
        } else _tokens)!!


    @Test
    fun simplestVariableDeclarationParser() {
        file = "SimplestVariableDeclaration"
        parser = variableDeclarationParser
        test()
    }

    @Test
    fun simpleTypedVariableDeclarationParser() {
        file = "SimpleTypedVariableDeclarationParser"
        parser = variableDeclarationParser
        test("Single SubType")
        test("Double SubType")
        test("Triple SubType")
        test("Huge SubType")
        parser = eofDeclarationParser
        test("EOF")
    }

    @Test
    fun simplestTypedVariableDeclarationParser() {
        file = "SimplestTypedVariableDeclarationParser"
        parser = variableDeclarationParser
        test()
    }

    @Test
    fun simplestAssignedVariableDeclarationParser() {
        file = "SimplestAssignedVariableDeclarationParser"
        parser = variableDeclarationParser
        test(message = "Var Test Case")
        test(message = "Val Test Case")
        test(message = "Assigned to a Reference")
        test(message = "Assigned to int")
        test(message = "Assigned to Int Long")
        test(message = "Assigned to Int Longer")
        test(message = "Assigned to Int Double")
        test(message = "Assigned to Int Float")
        parser = Section(EOF)
        test(message = "EOF Test Case ${tokens.peekNextToken}")

    }

    @Test
    fun simpleTypedSizedVariableDeclarationParser() {
        file = "SimpleTypedSizedVariableDeclarationParser"
        parser = variableDeclarationParser
        test("1\tLength Defined")
        test("2\tMin Length Defined")
        test("3\tMin&Max Length Defined")
        test("4\tNested With Size")
        test("5\tNester with min")
        test("6\tNester with min&max")
        parser = CommentsParser()
        test("Comment For: SubNested with size")
        test("Comment For: SubNested with min")
        test("Comment For: SubNested with min&max")
        /**TODO
         * TypeDeclaration does not have [size spepcs]
         * as this will affect Class parser
         * new Parser needs to be defined for
         * test("7\tSubNested with size")
         * test("8\tSubNested with min")
         * test("9\tSubNested with min&max")
         * */
        testEOF()
    }

    @Test
    fun simplestTypedAssignedVariableDeclarationParser() {
        file = "SimplestTypedVariableDeclarationParser"
        parser = variableDeclarationParser
        test("Simplest Variable Declaration ${tokens.peekNextToken}")
    }

    @Test
    fun variableDeclarationParser() {

        file = "VariableDeclarationParser"

        val tk = tokens
        assertTrue(ZeroOrMany(variableDeclarationParser) test tk)
        assertTrue(Section(EOF) test tk)
        assertTrue(!tk.hasRemItems)
    }


    @Test
    fun variableTypeDeclarationParser() {
        file = "VariableTypeDeclarationParser"
        parser = VariableTypeDeclarationParser()

        test("Simplest State")
        test("Simplest Generic State")
        test("Simplest Generic State")
        test("Complex State")
        test("Complex State Sized")
        testEOF()
    }

    @Test
    fun parametersParser() {
        file = "ParametersParser"
      // parser = ParametersParser()

        test("Simplest var")
        test("Simplest val")
        test("Simplest var Typed")
        test("Simplest val Typed")
        test("Complex varargs Typed")
        test("Complex varargs Typed Median")
        test("Complex varargs Typed First")
        test("Complex varargs Typed Last")
        testEOF()
    }

    private fun testEOF() {
        parser = eofDeclarationParser
        test("End Of File Parser")
    }

    private fun test(message: String = "Test Case", expected: Boolean = true) {
        if (expected)
            assertTrue(message) {
                val startToken = tokens.peekNextToken
                val test = parser test tokens
                println("Start Token = $startToken\tNext Token ${tokens.peekPrevToken}")
                test
            }
        else
            assertFalse(message) {
                val startToken = tokens.peekNextToken
                val test = parser test tokens
                println("Start Token = $startToken\tNext Token ${tokens.peekPrevToken}")
                test
            }
    }

}
