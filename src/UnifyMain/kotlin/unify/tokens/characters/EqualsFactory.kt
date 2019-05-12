package unify.factories.tokens.characters


import unify.factories.tokens.CharTokenFactory


class EqualsFactory : CharTokenFactory<Equals>() {
    override val char: Char = '='

    override fun invoke(): Equals {
        return Equals(char)
    }
}
