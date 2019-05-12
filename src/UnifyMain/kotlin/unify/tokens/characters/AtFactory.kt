package unify.factories.tokens.characters



import unify.factories.tokens.CharTokenFactory


class AtFactory : CharTokenFactory<At>() {

    override val char = '@'

    override fun invoke(): At {
        return At(char)
    }
}
