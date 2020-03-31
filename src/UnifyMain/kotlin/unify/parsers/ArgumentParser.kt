package unify.parsers

import language.parsers.ParserStatic
import language.sections.AlternativeSection

class ArgumentParser : ParserStatic(
        AlternativeSection(
                SingleArgumentParser()
        )
){
        override val TAG = "ArgumentParser"
}