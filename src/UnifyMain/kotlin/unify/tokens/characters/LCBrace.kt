package unify.factories.tokens.characters


import unify.factories.tokens.CharTokenFactory

class LCBrace : CharTokenFactory<LCBrace>() {

    override val char = '{'


    override fun invoke(): LCBrace {
        return LCBrace(char)
    }
}
