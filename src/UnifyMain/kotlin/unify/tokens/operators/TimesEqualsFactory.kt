package unify.factories.tokens.operators


import unify.tokens.OperatorFactory


class TimesEqualsFactory : OperatorFactory<TimesEquals>() {

    override var tokenString: String = "*="


    override fun invoke(tkString: String): TimesEquals {
        return TimesEquals(tokenString)
    }
}
