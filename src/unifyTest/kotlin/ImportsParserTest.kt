import lib.matcher.TestableStatic
import unify.parsers.ParametersParser
import unify.parsers.headers.ImportParser


import unify.tokens.strings.KeywordStatic
import kotlin.test.Test

class ImportsParserTest : ParserTest() {

    override val fileDir = "directives/imports/"


    override var parser: TestableStatic<String> = ImportParser()

    @Test
    fun `Simple Import`() {
        file = "SimpleImport"
    }

    @Test
    fun `Import As`() {
        file = "ImportAs"
    }


    @Test
    fun `Import All`() {
        file = "ImportAll"
    }

}