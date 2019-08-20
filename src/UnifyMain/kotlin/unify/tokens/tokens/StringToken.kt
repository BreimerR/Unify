package unify.tokens.tokens


abstract class StringTokenStatic : TokenStatic()

abstract class StringTokenClass(tokenString: String, l: Int, col: Int) : TokenStatic.Class(tokenString, l, col)
