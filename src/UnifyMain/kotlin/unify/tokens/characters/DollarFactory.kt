package unify.factories.tokens.characters


import unify.factories.tokens.CharTokenFactory

class DollarFactory : CharTokenFactory<Dollar>() {

    override val char = '$'

    override fun invoke(): Dollar {
        return Dollar(char)
    }
}
