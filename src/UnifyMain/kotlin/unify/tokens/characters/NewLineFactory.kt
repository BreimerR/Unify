package unify.factories.tokens.characters


import unify.factories.tokens.CharTokenFactory

class NewLineFactory : CharTokenFactory<NewLine>() {

    override val char = '\n'

    override fun invoke(): NewLine {
        return NewLine(char)
    }
}
