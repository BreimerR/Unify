package unify.factories.tokens.characters


import unify.factories.tokens.CharTokenFactory

class UnderscoreFactory : CharTokenFactory<Underscore>() {

    override val char = '_'


    override fun invoke(): Underscore {
        return Underscore(char)
    }
}
