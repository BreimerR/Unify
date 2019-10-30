package unify.tokens.characters

import lib.matcher.items.ItemStatic
import unify.tokens.tokens.CharacterStatic

class EscapedRStatic : CharacterStatic() {

    override val char = '\r'

    override fun invoke(tokenString: String, l: Int, col: Int): Class = Class(tokenString, l, col)

    override fun testItem(item: ItemStatic.Class<String>?) = if (item != null) item is Class else false
   
    class Class(tokenString: String, l: Int, col: Int) : CharacterStatic.Class(tokenString, l, col, EscapedR)
    
}

val EscapedR = EscapedRStatic()