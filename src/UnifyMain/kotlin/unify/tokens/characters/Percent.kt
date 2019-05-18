package unify.factories.tokens.characters


import unify.factories.tokens.CharTokenFactory

class Percent : CharTokenFactory<Percent>() {

    override val char = '%'


    override fun invoke(): Percent {
        return Percent(char)
    }
}
