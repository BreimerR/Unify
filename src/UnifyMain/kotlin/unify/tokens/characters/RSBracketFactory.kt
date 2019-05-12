package unify.factories.tokens.characters

import unify.factories.tokens.CharTokenFactory

class RSBracketFactory : CharTokenFactory<RSBracket>() {

    override var char = ']'

    override operator fun invoke(): RSBracket {
        return RSBracket(char)
    }

}
