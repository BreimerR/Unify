package unify.factories.tokens.characters


import unify.factories.tokens.CharTokenFactory

class RCBraceFactory : CharTokenFactory<RCBrace>() {
    override val char = '}'

    override fun invoke(): RCBrace {
        return RCBrace(char)
    }
}
