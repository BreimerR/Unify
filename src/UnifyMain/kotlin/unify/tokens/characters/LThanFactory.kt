package unify.factories.tokens.characters


import unify.factories.tokens.CharTokenFactory

class LThanFactory : CharTokenFactory<LThan>() {

    override val char = '<'


    override fun invoke(): LThan {
        return LThan(char)
    }
}
