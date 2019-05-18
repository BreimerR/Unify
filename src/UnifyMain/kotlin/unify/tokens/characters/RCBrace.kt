package unify.factories.tokens.characters


import unify.factories.tokens.CharTokenFactory

class RCBrace : CharTokenFactory<RCBrace>() {
    override val char = '}'

    override fun invoke(): RCBrace {
        return RCBrace(char)
    }
}
