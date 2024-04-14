import lib.matcher.TestableStatic
import unify.parsers.functions.FunctionParser
import kotlin.test.Test

class FunctionParserTest : ParserTest() {
    override var parser: TestableStatic<String> = FunctionParser()

    override val fileDir: String = "functions/";

    @Test
    fun `Simplest Function Declaration`() {
        file = "Simplest"
    }

    @Test
    fun `Simplest Function Declaration With Simplest Single Argument`() {
        file = "SimplestWIthSingleSimplestArgument"
    }

    @Test
    fun `Simplest Function Declaration With Simplest Double Argument`() {
        file = "SimplestWithMultipleSimplestArgument"
    }

    @Test
    fun `Simplest Function Declaration With Single Simple Typed Argument`() {
        file = "SimplestWithSingleSimpleTypedArgument"
    }


    @Test
    fun `Simplest Function Declaration With Single Simplest Typed Argument`() {
        file = "SimplestWithSingleSimplestTypedArgument"
    }

    @Test
    fun `Simplest Backup Value`() {
        file = "SimplestBackupValue"
    }

}