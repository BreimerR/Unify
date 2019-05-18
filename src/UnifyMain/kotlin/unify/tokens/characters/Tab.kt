package unify.tokens.characters



import unify.tokens.CharacterClass
import unify.tokens.CharacterStatic

class TabStatic : CharacterStatic() {

    override val char = '\t'
}

class TabClass : CharacterClass() {
    override val self = Tab

}


val Tab = TabStatic()