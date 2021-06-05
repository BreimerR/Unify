import kotlinx.cinterop.ByteVar
import kotlinx.cinterop.ByteVarOf
import kotlinx.cinterop.CValue
import language.sections.Section
import lib.matcher.TestableStatic
import platform.posix.dirname
import platform.posix.getcwd
import platform.posix.opendir
import platform.posix.realpath
import unify.ast.Tokens
import unify.ast.TokensStatic
import unify.parsers.variables.VariableDeclarationParser
import unify.tokens.tokens.EOF
import kotlin.test.AfterTest
import kotlin.test.assertFalse
import kotlin.test.assertTrue

abstract class ParserTest {

    protected val variableDeclarationParser
        get() = VariableDeclarationParser()

    private val eofDeclarationParser
        get() = Section(EOF)

    var file = ""
        set(value) {
            updated = value != field
            field = value
        }


    abstract var parser: TestableStatic<String>;

    var updated = false

    abstract val fileDir: String

    private val rootDir = "src/unifyTest/unify/"

    private var filePath: String = ""
        get() = if (updated) {
            field = "$rootDir/$fileDir/$file.u"
            field
        } else field

    private var _tokens: TokensStatic.Class? = null

    private val tokens: TokensStatic.Class
        get() = (if (updated) {
            _tokens = Tokens(filePath)
            updated = false
            _tokens
        } else _tokens)!!

    private fun testEOF() {
        parser = eofDeclarationParser
        test("End Of File Parser")
    }

    @AfterTest
    open fun afterEachTest() {
        test()
        testEOF()
    }

    private fun test(message: String = "Test Case", expected: Boolean = true) {
        assertTrue(message) {
            val startToken = tokens.peekNextToken
            val test = parser test tokens
            println("Start Token = $startToken\tNext Token ${tokens.peekPrevToken}")
            test
        }
    }
}