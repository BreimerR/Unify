package unify.factories.tokens.characters

import unify.factories.tokens.CharTokenFactory


class BSlashFactory : CharTokenFactory<BSlash>() {
    override val char: Char = '\\'

    override fun invoke(): BSlash {
        return BSlash(char)
    }
}
