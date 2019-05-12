package unify.factories.tokens.characters



import unify.factories.tokens.CharTokenFactory

class PlusFactory : CharTokenFactory<Plus>() {

    override val char = '+'


    override fun invoke(): Plus {
        return Plus(char)
    }
}
