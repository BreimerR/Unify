package unify.factories.tokens.characters


import unify.factories.tokens.CharTokenFactory


class DotFactory : CharTokenFactory<Dot>() {
    override val char: Char = '.'


    override fun invoke(): Dot {
        return Dot(char)
    }
}
