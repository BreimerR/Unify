package unify.factories.tokens.strings


class NumberFactory : StringTokenFactory<Number>() {

    override val tokenString: String = ""

    override var regex = Regex("[0-9][0-9]*")

    override fun invoke(tkString: String): Number {
        return Number(tkString)
    }

}