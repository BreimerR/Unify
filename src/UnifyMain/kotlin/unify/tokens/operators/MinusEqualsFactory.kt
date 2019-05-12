package unify.factories.tokens.operators


import unify.tokens.OperatorFactory


class MinusEqualsFactory : OperatorFactory<MinusEquals>() {

    override var tokenString: String = "-="


    override fun invoke(tkString: String): MinusEquals {
        return MinusEquals(tokenString)
    }
}
