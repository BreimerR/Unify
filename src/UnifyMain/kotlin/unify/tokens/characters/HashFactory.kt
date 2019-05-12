package unify.factories.tokens.characters


import unify.factories.tokens.CharTokenFactory

class HashFactory : CharTokenFactory<Hash>() {

    override val char = '#'


    override fun invoke(): Hash {
        return Hash(char)
    }
}
