package unify.factories.tokens.characters


import unify.factories.tokens.CharTokenFactory

class BTickFactory : CharTokenFactory<BTick>() {
    override val char = '`'

    override fun invoke(): BTick {
        return BTick(char)
    }
}
