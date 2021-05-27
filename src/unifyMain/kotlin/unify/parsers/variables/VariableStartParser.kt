package unify.parsers.variables

import language.parsers.ParserStatic
import language.sections.*
import lib.matcher.TestableStatic
import unify.parsers.ReferenceOperatorParser
import unify.parsers.TypeDeclarationParser
import unify.parsers.expressions.ExpressionParser
import unify.parsers.literals.ReferenceParser
import unify.parsers.numbers.IntegerParser
import unify.tokens.characters.*
import unify.tokens.strings.Identifier

class VariableStartParser : ParserStatic() {

    override val TAG = "VariableStartParser"

    override var sections: Array<out TestableStatic<String>>
        get() {
            return arrayOf(
                AlternativeSection(
                    Section(
                        // TODO should be a reference not necessarily an identifier
                        Section(Identifier, name = "VAR_NAME"),
                        OptionalSection(
                            Colon,
                            VariableTypeDeclarationParser(),
                            name ="VAR_TYPE"
                        ),
                        /**@Description
                         * This Section is here so that we can
                         * preserve the variable name despite destructing
                         * i.e
                         * func main({name,age}={String,String})
                         * in the above we can not reference the base object as it's reference isn't
                         * available to us
                         * func main(user:User{name,age})
                         * With this we are able to reference the base object in case we'd want
                         * to do something extra during run time of the variable
                         *
                         * */
                        OptionalSection(
                            DestructuringParser()
                        ),
                        OptionalSection(
                            ReferenceOperatorParser(),
                            AlternativeSection(
                                Section(
                                    ExpressionParser(),
                                    RepetitiveBySection(
                                        Coma,
                                        Dollar,
                                        ReferenceParser()
                                    )
                                ),
                                ExpressionParser(),
                                RepetitiveBySection(
                                    Coma,
                                    Dollar,
                                    ReferenceParser()
                                )

                            )
                        )
                    ),
                    Section(
                        /**@Description
                         * This Section is here so that we can
                         * preserve the variable name despite destructing
                         * i.e
                         * func main({name,age}={String,String})
                         * in the above we can not reference the base object as it's reference isn't
                         * available to us
                         * func main(user:User{name,age})
                         * With this we are able to reference the base object in case we'd want
                         * to do something extra during run time of the variable
                         *
                         * */
                        DestructuringParser(),
                        OptionalSection(
                            ReferenceOperatorParser(),
                            AlternativeSection(
                                Section(
                                    ExpressionParser(),
                                    RepetitiveBySection(
                                        Coma,
                                        Dollar,
                                        ReferenceParser(),
                                    )
                                ),
                                ExpressionParser(),
                                RepetitiveBySection(
                                    Coma,
                                    Dollar,
                                    ReferenceParser(),
                                )

                            )
                        )
                    )
                )
            )
        }
        set(value) {}
}
