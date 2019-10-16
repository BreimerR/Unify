package unify.parsers

import language.parsers.Parser
import language.sections.AlternativeSection

class ArgumentParser : Parser(
        AlternativeSection(
                SimpleArgumentParser(),
                DestructedArgumentParser()
        ),
        name = "ARGUMENT"
) {
    override val considerSpaces = false
}


