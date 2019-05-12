package unify.factories.tokens.characters


import unify.factories.tokens.CharTokenFactory

class SpaceFactory : CharTokenFactory<Space>() {

    override val char = ' '


    override fun invoke(): Space {
        return Space(char)
    }
}
