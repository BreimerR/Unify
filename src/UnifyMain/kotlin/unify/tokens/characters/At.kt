package unify.tokens.characters


import unify.tokens.CharacterClass
import unify.tokens.CharacterStatic


class AtStatic : CharacterStatic() {
    override val char = '@'

    override fun invoke(tokenString: String, l: Int, col: Int): CharacterClass {
        return AtClass(tokenString, l, col)
    }
}


class AtClass(tokenString: String, l: Int, col: Int) : CharacterClass(tokenString, l, col){
    override val self = At

}

val At = AtStatic()
