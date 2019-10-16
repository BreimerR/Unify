package language.parsers

import language.sections.Section
import lib.matcher.sections.Section as LSection


open class Parser(
        vararg parseSections: LSection<String>,
        name: String? = null,
        considerSpaces: Boolean = false
) : Section(
        *parseSections,
        name = name,
        considerSpaces = considerSpaces
)

inline fun <reified T> Array<out T>.unshift(item: T): Array<T> {
    var res = arrayOf(item)

    this.forEach {
        res += it
    }

    return res
}