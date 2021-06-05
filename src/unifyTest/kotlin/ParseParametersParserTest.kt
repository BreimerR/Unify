import lib.matcher.TestableStatic
import unify.parsers.ParametersParser
import kotlin.test.AfterTest
import kotlin.test.Test

class ParseParametersParserTest : ParserTest() {

    override var parser: TestableStatic<String> = ParametersParser()

    override val fileDir = "methods/parameters/"

    @Test
    fun simpleVal() {
        file = "SimpleVal"
    }

    @Test
    fun simpleValTyped() {
        file = "SimpleValTyped"
    }

    @Test
    fun simpleVar() {
        file = "SimpleVar"
    }

    @Test
    fun simpleVarArgs() {
        file = "SimpleVarArgs"
    }

    @Test
    fun simpleVarArgsFirst() {
        file = "SimpleVarArgsFirst"
    }

    @Test
    fun simpleVarArgsLast() {
        file = "SimpleVarArgsLast"
    }

    @Test
    fun simpleVarArgsMedian() {
        file = "SimpleVarArgsMedian"
    }

    @Test
    fun complexVarArgsMedian() {
        file = "ComplexVarArgsMedian"
    }

    @Test
    fun simpleVarArgsTyped() {
        file = "SimpleVarArgsTyped"
    }

}