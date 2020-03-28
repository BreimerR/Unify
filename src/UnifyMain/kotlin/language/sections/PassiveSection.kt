package language.sections

import System
import language.ast.TokensStatic
import lib.matcher.TestableStatic
import lib.matcher.items.ItemsStatic
import lib.matcher.sections.SectionStatic

open
class PassiveSection(
        vararg sections: TestableStatic<String>,
        val considerSeparation: Boolean = false,
        val considerNewLine: Boolean = false,
        val considerSpaces: Boolean = false
) : SectionStatic<String>(*sections) {

    var test: Boolean = false

    override fun test(items: ItemsStatic.Class<String>): Boolean {
        return if (items is TokensStatic.Class) {
            items.pauseIndex

            items.saveState

            items.considerSeparation = considerSeparation

            items.updateStates(
                    considerSpaces,
                    considerNewLine,
                    considerSeparation
            )

            test = super.test(items)

            items.resumeIndex

            items.restoreState

            //  println("passive = $test \n does not progress the index of the passer nor does it collect items")
            if (System.DEBUG_POSITIVES && test) println("PassiveSection = $test \t token =  ${items.token}  \t token.value = ${items.token?.value}")


            test
        } else false
    }
}