package unify.factories.tokens.characters


import unify.factories.tokens.CharTokenFactory

class LSBracketFactory : CharTokenFactory<LSBracket>() {

    override val char = '['


    override fun invoke(): LSBracket {
        return LSBracket(char)
    }
}
