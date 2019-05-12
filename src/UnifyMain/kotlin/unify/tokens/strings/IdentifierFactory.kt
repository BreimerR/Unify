package unify.factories.tokens.strings


abstract class IdentifierFactory<T : Identifier> : StringTokenFactory<Identifier>() {

    // not using tkString in this case
    override val tokenString: String = ""

    abstract override fun invoke(tkString: String): T
}

