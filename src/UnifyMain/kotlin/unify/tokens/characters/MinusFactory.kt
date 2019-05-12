package unify.factories.tokens.characters


import unify.factories.tokens.CharTokenFactory

class MinusFactory : CharTokenFactory<Minus>() {

    override val char = '-'


    override fun invoke(): Minus {
        return Minus(char)
    }
}
