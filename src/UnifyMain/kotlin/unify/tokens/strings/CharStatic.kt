package unify.tokens.strings

import lib.matcher.items.ItemStatic

class CharStatic : IdentifierStatic() {
    
    override fun testItem(item: ItemStatic.Class<String>?): Boolean = super.testItem(item) && item?.value?.length == 1

    override fun invoke(tokenString: String, l: Int, col: Int) = Class(tokenString, l, col)

    open class Class(tokenString: String, l: Int, col: Int) : IdentifierStatic.Class(tokenString, l, col) {
        
        override val self by lazy {
            Character
        }

    }
}

val Character = CharStatic()