package unify.factories.tokens.characters


import unify.factories.tokens.CharTokenFactory

class PercentFactory : CharTokenFactory<Percent>() {

    override val char = '%'


    override fun invoke(): Percent {
        return Percent(char)
    }
}
