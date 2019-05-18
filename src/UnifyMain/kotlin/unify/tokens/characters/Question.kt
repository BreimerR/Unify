package unify.tokens.characters

import unify.tokens.tokens.CharacterClass
import unify.tokens.tokens.CharacterStatic

val Question = QuestionStatic()


class QuestionStatic : CharacterStatic() {

    override val char = '?'

    override fun invoke(tokenString: String, l: Int, col: Int): QuestionClass = QuestionClass(tokenString, l, col)
}

class QuestionClass(tokenString: String, l: Int, col: Int) : CharacterClass(tokenString, l, col) {
    override val self = Question
}