package unify.factories.tokens.strings


class KeywordFactory(override val tokenString: String) : IdentifierTokenFactory<Keyword>() {

    var keywords: String = "(infix|prefix|class|abstract|closed|trait|interface|public|static|void|null|when|for|if|elif|aka|else|get|set|switch|while|new|return|throw|import|do|TODO|todo)"

    override var regex = Regex("([a-zA-Z][a-zA-Z0-9_]*|_+[a-zA-Z0-9_]*)")

    override fun invoke(tkString: String): Keyword {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}
