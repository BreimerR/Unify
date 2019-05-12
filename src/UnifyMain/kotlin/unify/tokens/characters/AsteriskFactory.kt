package unify.factories.tokens.characters

import unify.factories.tokens.CharTokenFactory

class AsteriskFactory : CharTokenFactory<Asterisk>() {

    override val char: Char = '*'

    override fun invoke(): Asterisk {
        return Asterisk(char)
    }


}
