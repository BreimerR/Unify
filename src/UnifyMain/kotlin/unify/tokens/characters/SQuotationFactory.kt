package unify.factories.tokens.characters


import unify.factories.tokens.CharTokenFactory

class SQuotationFactory : CharTokenFactory<SQuotation>() {

    override val char = '\''

    override fun invoke(): SQuotation {
        return SQuotation(char)
    }
}
