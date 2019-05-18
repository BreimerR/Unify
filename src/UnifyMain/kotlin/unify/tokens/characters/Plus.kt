package unify.factories.tokens.characters



import unify.factories.tokens.CharTokenFactory

class Plus : CharTokenFactory<Plus>() {

    override val char = '+'


    override fun invoke(): Plus {
        return Plus(char)
    }
}
