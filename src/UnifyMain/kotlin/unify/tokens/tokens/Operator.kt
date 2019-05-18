package unify.tokens.tokens


abstract class OperatorStatic : TokenStatic() {
    abstract val tokenString: String

    override val regex: Regex
        get() = Regex(tokenString)
}

abstract class OperatorClass(tokenString: String, l: Int, col: Int) : TokenClass(tokenString, l, col)

