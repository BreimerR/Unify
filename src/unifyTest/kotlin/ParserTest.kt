import language.sections.Section
import lib.matcher.TestableStatic
import unify.ast.Tokens
import unify.ast.TokensStatic
import unify.parsers.variables.VariableDeclarationParser
import unify.tokens.tokens.EOF
import kotlin.test.assertFalse
import kotlin.test.assertTrue

open class ParserTest {

    protected val variableDeclarationParser
        get() = VariableDeclarationParser()

    protected val eofDeclarationParser
        get() = Section(EOF)

    var file = ""
        set(value) {
            updated = value != field
            field = value
        }


    open var parser: TestableStatic<String> = Section(EOF)

    var updated = false

    open val fileDir = "/opt/Projects/Kotlin/Unify/master/src/unifyTest/unify/"

    protected var filePath: String = ""
        get() = if (updated) {
            field = "$fileDir$file.u"
            field
        } else field

    protected var _tokens: TokensStatic.Class? = null

    protected val tokens: TokensStatic.Class
        get() = (if (updated) {
            _tokens = Tokens(filePath)
            updated = false
            _tokens
        } else _tokens)!!

    protected fun testEOF() {
        parser = eofDeclarationParser
        test("End Of File Parser")
    }

    protected fun test(message: String = "Test Case", expected: Boolean = true) {
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