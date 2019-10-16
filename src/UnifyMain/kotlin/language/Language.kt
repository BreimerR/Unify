package language


import lib.oop.classes.Class as SClass
import language.ast.TokensStatic
import language.parsers.Parser
import lib.oop.classes.StaticClass

abstract class LanguageStatic : StaticClass() {

    abstract val parsers: Array<Parser>

    abstract class Class : SClass<LanguageStatic>() {
        abstract val tokens: TokensStatic.Class

        private val parser: Parser
            get() {

                for (parser in self.parsers) {
                    val i = tokens.i
                    val spacesState = tokens.considerSpaces
                    tokens.considerSpaces = parser.considerSpaces
                    if (parser test tokens) {
                        tokens.considerSpaces = spacesState
                        return parser
                    } else tokens.i = i
                }

                throw Error("No valid parser")
            }

        fun parse() {
            while (tokens.hasRemItems) {
                println(parser)
            }
        }
    }
}


