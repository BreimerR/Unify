package unify.factories.tokens.characters


import unify.factories.tokens.CharTokenFactory

class EscapedRFactory : CharTokenFactory<EscapedR>() {
    override val char = '\r'

    override fun invoke(): EscapedR {
        return EscapedR(char)
    }
}
