package unify.factories.tokens.characters


import unify.factories.tokens.CharTokenFactory

class Space : CharTokenFactory<Space>() {

    override val char = ' '


    override fun invoke(): Space {
        return Space(char)
    }
}
