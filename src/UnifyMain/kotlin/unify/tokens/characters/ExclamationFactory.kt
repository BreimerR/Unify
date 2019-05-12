package unify.factories.tokens.characters


import unify.factories.tokens.CharTokenFactory

class ExclamationFactory : CharTokenFactory<Exclamation>() {

    override val char = '!'


    override fun invoke(): Exclamation {
        return Exclamation(char)
    }
}
