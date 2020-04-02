package language.sections

import DEBUG_NEGATIVES
import DEBUG_POSITIVES
import DEBUG_POSITIVE_PARSERS
import DEBUG_SECTIONS
import Log
import language.ast.TokensStatic
import lib.collections.array.get
import lib.collections.array.last
import lib.matcher.TestableStatic
import lib.matcher.items.ItemsStatic
import lib.matcher.sections.RepetitiveSectionStatic
import DEBUG as SYS_DEBUG
import lib.matcher.sections.RepetitiveBySection as BaseRepetitiveBySection

open class RepetitiveBySection : BaseRepetitiveBySection<String> {

    val TAG = "RepetitiveBySection"

    var considerSeparation = false
    var considerSpaces = false
    var considerNewLines = false

    constructor(
            vararg sections: TestableStatic<String>,
            considerSeparation: Boolean = false,
            considerSpaces: Boolean = false,
            considerNewLines: Boolean = false,
            name: String? = null,
            minCount: Int = 0,
            maxCount: Int = RepetitiveSectionStatic.maxCount
    ) : super(
            section = Section(*sections[0..(sections.size - 2)].toTypedArray()),
            by = sections.last, minCount = minCount, maxCount = maxCount, name = name
    ) {
        this.considerNewLines = considerNewLines
        this.considerSeparation = considerSeparation
        this.considerSpaces = considerSpaces
    }

    constructor(
            vararg sections: TestableStatic<String>,
            name: String? = null,
            minCount: Int = 0,
            maxCount: Int = RepetitiveSectionStatic.maxCount
    ) : this(
            sections = *sections,
            considerSeparation = false,
            considerSpaces = false,
            considerNewLines = false,
            minCount = minCount,
            maxCount = maxCount,
            name = name
    )

    constructor(section: TestableStatic<String>, by: TestableStatic<String>, name: String? = null) : super(section = section, by = by, name = name)

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

            debug(items, test)

            test

        } else false
    }

    val DEBUG
        get() = SYS_DEBUG && DEBUG_SECTIONS

    open fun debug(items: TokensStatic.Class, test: Boolean) {
        if (DEBUG) {

            if (DEBUG_POSITIVES && test) Log.d(TAG, "test =  $test \t token =  ${items.token}  \t token.value = ${items.token}")
            if (DEBUG_NEGATIVES) Log.d(TAG, "test = $test \t token =  ${items.token}  \t token.value = ${items.token}")

            if (DEBUG_POSITIVE_PARSERS && test) Log.d(TAG, "test = $test\ttoken = ${items.token}\ttoken.value = ${items.token}")

        }
    }

}