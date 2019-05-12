package unify.factories.tokens.characters


import unify.factories.tokens.CharTokenFactory

class TabFactory : CharTokenFactory<Tab>() {

    override val char = '\t'


    override fun invoke(): Tab {
        return Tab(char)
    }
}
