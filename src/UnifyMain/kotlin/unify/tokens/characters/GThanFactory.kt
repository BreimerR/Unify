package unify.factories.tokens.characters


import unify.factories.tokens.CharTokenFactory

class GThanFactory : CharTokenFactory<GThan>() {

    override val char = '>'

    override fun invoke(): GThan {
        return GThan(char)
    }
}
