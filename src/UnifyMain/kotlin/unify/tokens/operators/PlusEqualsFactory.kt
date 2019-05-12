package unify.factories.tokens.operators


import unify.tokens.OperatorFactory


class PlusEqualsFactory : OperatorFactory<PlusEquals>() {

    override var tokenString: String = "+="

    override fun invoke(tkString: String): PlusEquals {
        return PlusEquals(tkString)
    }
}
