package unify.factories.tokens.characters


import unify.factories.tokens.CharTokenFactory

class RBracketFactory : CharTokenFactory<RBracket>() {

    override val char = ')'


    override fun invoke(): RBracket {
        return RBracket(char)
    }
}
