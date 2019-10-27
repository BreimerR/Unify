package unify.tokens.tokens

import lib.matcher.items.ItemStatic
import lib.matcher.items.ItemsStatic
import unify.tokens.strings.IdentifierStatic
import unify.tokens.strings.KeywordStatic


abstract class StringTokenStatic : TokenStatic() {

    abstract class Class(tokenString: String, l: Int, col: Int) : TokenStatic.Class(tokenString, l, col) {

    }
}


