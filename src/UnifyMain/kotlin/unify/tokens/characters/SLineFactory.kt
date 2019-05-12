package unify.factories.tokens.characters


import unify.factories.tokens.CharTokenFactory


class SLineFactory : CharTokenFactory<SLine>() {

    override val char = '~'


    override fun invoke(): SLine {
        return SLine(char)
    }
}
