package language.sections

import language.ast.TokensStatic
import lib.cli.CLIArguments
import lib.cli.CLIArgumentsClass
import lib.oop.classes.StaticClass
import unify.ast.Tokens
import lib.oop.classes.Class as OClass

abstract class TestableStatic<T> : StaticClass() {

    abstract class Class<T> : OClass<TestableStatic<T>>()
}

open class ItemStatic<T> : TestableStatic<T>()


open class ItemsStatic<T> : TestableStatic<T>() {

    class Class<T>(override val self: TestableStatic<T>) : TestableStatic.Class<T>()
}

class Token : ItemStatic<String>()


class TokensStatic : ItemsStatic<String>()


open class SectionStatic<T> : TestableStatic<T>() {

    abstract class Class<T> : TestableStatic.Class<T>()
}


open class ParserStatic : SectionStatic<String>()

open class IntegerParserStatic : ParserStatic()

val IntegerParser = IntegerParserStatic()

open class EOFParserStatic : ParserStatic()

val EOFParser = EOFParserStatic()

abstract class LanguageStatic : SectionStatic<String>() {

    abstract class Class : SectionStatic.Class<String>() {

        abstract val sections: Array<ParserStatic>

        abstract val tokens: TokensStatic.Class

    }

}


class UnifyStatic : LanguageStatic() {

    operator fun invoke(args: CLIArgumentsClass): Class = Class(args)

    class Class(args: CLIArgumentsClass) : LanguageStatic.Class() {

        override val self by lazy {
            Unify
        }

        override val tokens = Tokens(args["-fileName"], args["-fileEncoding"])

        override val sections = arrayOf(
                IntegerParser,
                EOFParser
        )

    }
}


val Unify = UnifyStatic()

fun mains(arguments: Array<String>) {
    val args = CLIArguments(arguments)

    val unify = Unify(args)

}