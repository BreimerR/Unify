package unify.factories.tokens.operators


import unify.tokens.OperatorFactory


class ElvisOperatorFactory : OperatorFactory<ElvisOperator>() {

    override var tokenString: String = "?:"


    override fun invoke(tkString: String): ElvisOperator {
        return ElvisOperator(tokenString)
    }
}
