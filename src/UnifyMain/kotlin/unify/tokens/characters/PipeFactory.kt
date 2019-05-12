package unify.factories.tokens.characters


import unify.factories.tokens.CharTokenFactory

class PipeFactory : CharTokenFactory<Pipe>() {

    override val char = '|'


    override fun invoke(): Pipe {
        return Pipe(char)
    }
}