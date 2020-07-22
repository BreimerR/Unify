package unify.tokens.strings

import lib.matcher.items.ItemStatic
import lib.matcher.items.ItemsStatic
import lib.text.asString

class KeywordStatic(private val keyword: String? = null) : IdentifierStatic(value = keyword ?: "") {

    private var keywords: String = "(package|protected|private|public|final|func|data|infix|prefix|act|class|abstract|closed|trait|public|static|void|null|when|for|if|elif|aka|else|switch|while|then|new|return|throw|do|TODO|todo|enum|var|val|const|impl|throws|returns|break|default|override)"

    override fun invoke(tokenString: String, l: Int, col: Int): Class = Class(tokenString, l, col)

    override fun test(items: ItemsStatic.Class<Char>): Boolean {
        val i = items.nextIndex

        return if (super.test(items))
            items[i..items.nextIndex].toTypedArray().asString matches keywords.toRegex()
        else false
    }

    override fun testItem(item: ItemStatic.Class<String>?): Boolean {
        return if (item is Class) {
            if (keyword != null) {
                item.value == keyword
            } else true
        } else false

    }

    class Class(tokenString: String, l: Int, col: Int) : IdentifierStatic.Class(tokenString, l, col) {
        override val self by lazy {
            Keyword
        }
    }

}

val Keyword = KeywordStatic()