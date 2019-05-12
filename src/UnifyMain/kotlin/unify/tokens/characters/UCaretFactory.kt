package unify.factories.tokens.characters


import unify.factories.tokens.CharTokenFactory

class UCaretFactory : CharTokenFactory<UCaret>() {

    override val char = '^'


    override fun invoke(): UCaret {
        return UCaret(char)
    }
}
