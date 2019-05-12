package unify.factories.tokens.characters

import unify.factories.tokens.CharTokenFactory


class EOFFactory : CharTokenFactory<EOF>() {
    override fun test(file: File): Boolean {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override val char: Char = (-1).charVal

    override fun invoke(): EOF {
        return EOF(char)
    }
}
