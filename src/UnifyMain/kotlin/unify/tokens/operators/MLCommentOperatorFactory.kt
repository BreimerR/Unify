package unify.factories.tokens.operators


import unify.tokens.OperatorFactory


class MLCommentOperatorFactory : OperatorFactory<MLCommentOperator>() {

    override var tokenString: String = "/*"

    override fun invoke(tkString: String): MLCommentOperator {
        return MLCommentOperator(tokenString)
    }
}
