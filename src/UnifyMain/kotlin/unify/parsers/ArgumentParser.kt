package unify.parsers

import language.parsers.Parser
import lib.matcher.sections.AlternativeSection

class ArgumentParser : Parser(
        AlternativeSection(
                SimpleArgumentParser(),
                DestructedArgumentParser()
        ),
        name = "ARGUMENT"
) {
    override val considerSpaces = false
}


