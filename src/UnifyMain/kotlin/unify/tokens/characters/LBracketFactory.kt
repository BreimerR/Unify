package unify.factories.tokens.characters


import unify.factories.tokens.CharTokenFactory

class LBracketFactory : CharTokenFactory<LBracket>() {

    override val char = '('


    override fun invoke(): LBracket {
        return LBracket(char)
    }
}
