import lib.matcher.TestableStatic
import unify.parsers.ArithmeticAdjustmentParser
import unify.parsers.IncrementalParser
import kotlin.test.Test

class IncrementalParserTest : ArithmeticParserTest() {

    override var parser: TestableStatic<String> = IncrementalParser()


    @Test
    fun `Increase By Self`(){
        file = "IncreaseBySelf"
    }

}