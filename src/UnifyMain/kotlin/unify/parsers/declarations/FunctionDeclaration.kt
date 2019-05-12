package unify.parsers.declarations


class FunctionDeclarationStatic : DeclarationStatic() {
    operator fun invoke(): FunctionDeclarationClass = FunctionDeclarationClass()
}


class FunctionDeclarationClass : DeclarationClass() {
    override val self = FunctionDeclaration;
}

var FunctionDeclaration = FunctionDeclarationStatic()