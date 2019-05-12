package unify.factories.tokens.characters



import unify.factories.tokens.CharTokenFactory


class DQuotationFactory : CharTokenFactory<DQuotation>() {

    override val char: Char = '"'

    override fun invoke(): DQuotation {
        return DQuotation(char)
    }
}
