package unify.parsers

/*package terminator =  space*/
import language.parsers.ParserStatic
import language.sections.AlternativeSection
import unify.tokens.tokens.EOF

/*imports terminator = space new line is for formatter*/

class TerminatedParser(val parseStatement: ParserStatic) : ParserStatic(
        parseStatement,
        AlternativeSection(
                EOF
        )
) {

    init {


    }
    /**
     * terminator is a new line or semi colon
    init{
    var smile = 12, age = 20

    var age = 12

    var smile = 20
    }*/
}