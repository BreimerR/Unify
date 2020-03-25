package unify.parsers

/*package terminator =  space*/
import language.parsers.AlternativeParser
import language.parsers.ParserStatic
import unify.tokens.tokens.EOF

/*imports terminator = space new line is for formatter*/


/** TODO
 * Supposed to parse default terminator
 * default terminator is
 * ; or newLine
 * */
class TerminatorParserPartial : ParserStatic(
        AlternativeParser(
                EOF,

                considerSeparation = true
        ),
        considerSeparation = true
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