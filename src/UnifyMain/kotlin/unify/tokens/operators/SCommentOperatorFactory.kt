package unify.factories.tokens.operators


import unify.tokens.OperatorFactory


class SCommentOperatorFactory : OperatorFactory<SCommentOperator>() {

    override var tokenString: String = "//"

    override fun invoke(tkString: String): SCommentOperator {
        return SCommentOperator(tokenString)
    }
}
