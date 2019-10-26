package language.parsers

import language.sections.SectionStatic


class ParserStatic : SectionStatic() {

    class Class : SectionStatic.Class() {
        override val self = Parser;
    }

}


val Parser = ParserStatic()
