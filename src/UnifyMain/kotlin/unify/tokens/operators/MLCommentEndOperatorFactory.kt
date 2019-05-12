package unify.factories.tokens.operators


import unify.tokens.OperatorFactory


class MLCommentEndOperatorFactory : OperatorFactory<MLCommentEndOperator>() {

    override var tokenString: String = "*/"


    override fun invoke(tkString: String): MLCommentEndOperator {
        return MLCommentEndOperator(tokenString)
    }
}
