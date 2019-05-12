package unify.factories.tokens.characters


import unify.factories.tokens.CharTokenFactory

class QuestionFactory : CharTokenFactory<Question>() {

    override val char = '?'


    override fun invoke(): Question {
        return Question(char)
    }
}
