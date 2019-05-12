package unify.factories.tokens.operators


import unify.tokens.OperatorFactory


class DoOperatorFactory : OperatorFactory<DoOperator>() {

    override var tokenString: String = "->"


    override fun invoke(tkString: String): DoOperator {
        return DoOperator(tokenString)
    }
}
