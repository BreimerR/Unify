
package unify.tokens.characters


import lib.matcher.items.ItemsStatic
import unify.tokens.tokens.CharacterStatic

val Ampersand = AmpersandStatic()


class AmpersandStatic : CharacterStatic() {


    override val char = '&'

    override fun invoke(tokenString: String, l: Int, col: Int): Class = Class(tokenString, l, col)

    class Class(tokenString: String, l: Int, col: Int) : CharacterStatic.Class(tokenString, l, col, Ampersand)
}
