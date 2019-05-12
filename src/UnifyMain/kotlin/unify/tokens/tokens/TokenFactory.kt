package unify.factories.tokens

// remove File reference in the language as it is more code
// i.e overrides should not be required to have a type as its type is already.

import language.factories.tokens.TokenFactory as Factory


// StringTokenFactory
// CharTokenFactory
// OperatorTokenFactory
abstract class TokenFactory : Factory<Token>() {


}


