package unify.tokens.characters

import lib.matcher.items.ItemStatic
import unify.tokens.tokens.CharacterStatic

class UnderscoreStatic : CharacterStatic() {

    override val char = '_'

    override fun invoke(tokenString: String, l: Int, col: Int): Class = Class(tokenString, l, col)

    override fun testItem(item: ItemStatic.Class<String>?) = if (item != null) item is Class else false
   
    class Class(tokenString: String, l: Int, col: Int) : CharacterStatic.Class(tokenString, l, col, Underscore)
    
}

val Underscore = UnderscoreStatic()