import lib.matcher.TestableStatic
import unify.parsers.ParametersParser
import unify.parsers.functions.FunctionParser
import unify.parsers.functions.MethodParser
import kotlin.test.AfterTest
import kotlin.test.Test

class MethodsParserTest : ParserTest() {

    override var parser: TestableStatic<String> = MethodParser()

    override val fileDir = "${super.fileDir}/methods/bodies/"

    @Test
    fun simplestMethod() {
        file = "SimplestMethod"
    }

    @Test
    fun simpleMethodWithParameter() {
        file = "SimpleMethodWithParameter"
    }

    @Test
    fun simpleMethodWithTypedParameter() {
        file = "SimpleMethodWithTypedParameter"
    }

    @Test
    fun simpleMethodWithParameters() {
        file = "SimpleMethodWithParameters"
    }

    @Test
    fun simpleMethodWithTypedParameters() {
        file = "SimpleMethodWithTypedParameters"
    }



}