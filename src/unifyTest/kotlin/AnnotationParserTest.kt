import lib.matcher.TestableStatic
import unify.parsers.functions.FunctionParser
import unify.parsers.headers.AnnotationParser
import kotlin.test.Test

class AnnotationParserTest : ParserTest() {

    override var parser: TestableStatic<String> = AnnotationParser()


    override val fileDir = "${super.fileDir}/directives/annotations/"

    @Test
    fun simpleAnnotation() {
        file = "SimpleAnnotation"
    }

    @Test
    fun annotatedFunction() {
        parser = FunctionParser()
        file = "AnnotatedFunction"
    }

}