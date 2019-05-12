package unify.factories.tokens.characters


import unify.factories.tokens.CharTokenFactory

class FSlashFactory : CharTokenFactory<FSlash>() {

    override val char = '/'


    override fun invoke(): FSlash {
        return FSlash(char)
    }
}
