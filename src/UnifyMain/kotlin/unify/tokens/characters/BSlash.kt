package unify.tokens.characters

import unify.tokens.tokens.CharacterClass
import unify.tokens.tokens.CharacterStatic


class BSlashStatic : CharacterStatic() {
    override val char = '\\'


    override fun invoke(tokenString: String, l: Int, col: Int): CharacterClass = BSlashClass(tokenString, l, col)
}


class BSlashClass(tokenString: String, l: Int, col: Int) : CharacterClass(tokenString, l, col) {
    override val self = BSlash
}


val BSlash = BSlashStatic()
