package unify.factories.tokens.characters


import unify.factories.tokens.CharTokenFactory

class SColonFactory : CharTokenFactory<SColon>() {

    override val char = ';'


    override fun invoke(): SColon {
        return SColon(char)
    }
}
