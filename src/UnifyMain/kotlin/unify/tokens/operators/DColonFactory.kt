package unify.factories.tokens.operators


import unify.tokens.OperatorFactory


class DColonFactory : OperatorFactory<DColonOperator>() {

    override var tokenString: String = "::"


    override fun invoke(tkString: String): DColonOperator {
        return DColonOperator(tokenString)
    }
}
