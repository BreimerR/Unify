package language.sections

import System
import language.ast.TokensStatic
import lib.collections.array.get
import lib.collections.array.last
import lib.matcher.TestableStatic
import lib.matcher.items.ItemsStatic
import lib.matcher.sections.RepetitiveSectionStatic
import lib.matcher.sections.RepetitiveBySection as BaseRepetitiveBySection

class RepetitiveBySection : BaseRepetitiveBySection<String> {

    var considerSeparation = false
    var considerSpaces = false
    var considerNewLines = false

    constructor(
            vararg sections: TestableStatic<String>,
            considerSeparation: Boolean = false,
            considerSpaces: Boolean = false,
            considerNewLines: Boolean = false,
            minCount: Int = 0,
            maxCount: Int = RepetitiveSectionStatic.maxCount
    ) : super(
            section = Section(*sections[0..sections.size - 2].toTypedArray()),
            by = sections.last, minCount = minCount, maxCount = maxCount
    ) {
        this.considerNewLines = considerNewLines
        this.considerSeparation = considerSeparation
        this.considerSpaces = considerSpaces
    }

    constructor(
            vararg sections: TestableStatic<String>,
            minCount: Int = 0,
            maxCount: Int = RepetitiveSectionStatic.maxCount
    ) : this(
            sections = *sections,
            considerSeparation = false,
            considerSpaces = false,
            considerNewLines = false,
            minCount = minCount,
            maxCount = maxCount
    )

    constructor(section: TestableStatic<String>, by: TestableStatic<String>) : super(section = section, by = by)

    override fun test(items: ItemsStatic.Class<String>): Boolean {
        return if (items is TokensStatic.Class) {
            items.saveState

            items.updateStates(
                    considerSpaces,
                    considerNewLines,
                    considerSeparation
            )

            val test = super.test(items)

            items.restoreState
            if (System.DEBUG) println("RepetitiveBySection = $test \t token =  ${items.token}  \t token.value = ${items.token?.value}")

            if (System.DEBUG_POSITIVES && test) println("PassiveSection Returns $test \t token =  ${items.token}  \t token.value = ${items.token?.value}")

            test
        } else false
    }


}