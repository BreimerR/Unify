package unify.factories.tokens.characters

import unify.factories.tokens.CharTokenFactory

class ComaFactory : CharTokenFactory<Coma>() {


    override var char = ','

    override operator fun invoke(): Coma {
        return Coma(char)
    }

}
