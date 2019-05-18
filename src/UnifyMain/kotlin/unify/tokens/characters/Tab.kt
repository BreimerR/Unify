package unify.tokens.characters


import unify.tokens.tokens.CharacterClass
import unify.tokens.tokens.CharacterStatic

class TabStatic : CharacterStatic() {

    override val char = '\t'

    override fun invoke(tokenString: String, l: Int, col: Int): CharacterClass = TabClass(tokenString, l, col)
}

class TabClass(tokenString: String, l: Int, col: Int) : CharacterClass(tokenString, l, col) {
    override val self = Tab

}


val Tab = TabStatic()