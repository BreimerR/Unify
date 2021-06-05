import lib.matcher.TestableStatic
import unify.parsers.DecrementalParser
import kotlin.test.Test

class DecrementalParserTest : ArithmeticParserTest() {

    override var parser: TestableStatic<String> = DecrementalParser()

    @Test
    fun `Decrease By Self`(){
        file = "DecreaseBySelf"
    }
}