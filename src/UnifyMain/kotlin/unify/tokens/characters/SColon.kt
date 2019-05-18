package unify.factories.tokens.characters


import unify.factories.tokens.CharTokenFactory

class SColon : CharTokenFactory<SColon>() {

    override val char = ';'


    override fun invoke(): SColon {
        return SColon(char)
    }
}
