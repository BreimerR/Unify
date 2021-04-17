import lib.matcher.TestableStatic
import unify.parsers.ParametersParser
import unify.parsers.headers.ImportParser


import unify.tokens.strings.KeywordStatic
import kotlin.test.Test

class ImportsParserTest : ParserTest() {

    override val fileDir = "${super.fileDir}/directives/imports/"


    override var parser: TestableStatic<String> = ImportParser()

    @Test
    fun simpleImport() {
        file = "SimpleImport"
    }
}