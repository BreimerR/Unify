package unify.factories.tokens.operators


import unify.tokens.OperatorFactory


class ReturnOperatorFactory : OperatorFactory<ReturnOperator>() {

    override var tokenString: String = "=>"


    override fun invoke(tkString: String): ReturnOperator {
        return ReturnOperator(tokenString)
    }
}
