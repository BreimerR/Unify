package unify.factories.tokens.characters


import unify.factories.tokens.CharTokenFactory


class SLine : CharTokenFactory<SLine>() {

    override val char = '~'


    override fun invoke(): SLine {
        return SLine(char)
    }
}
