package unify.parsers

/*package terminator =  space*/
import language.parsers.AlternativeParser
import language.parsers.ParserStatic
import language.sections.PassiveSection
import language.sections.Section
import unify.tokens.characters.NewLine
import unify.tokens.characters.SColon
import unify.tokens.tokens.EOF

/*imports terminator = space new line is for formatter*/


/** TODO
 * Supposed to parse default terminator
 * default terminator is
 * ; or newLine
 * */
// if a parser fails it should restore all the used up spaces or new lines
class TerminatorParserPartial : ParserStatic(
        // structure of the alternative parser is important else the termination will not work
        AlternativeParser(
                SColon,
                Section(
                        NewLine,
                        considerNewLines = true
                ),
                PassiveSection(EOF),
                considerSeparation = false
        ),
        considerSeparation = false
) {

    override val TAG = "TerminatorParserPartial"

    init {
        val age = 12

    }
    /**
     * terminator is a new line or semi colon
    init{
    var smile = 12, age = 20

    var age = 12

    var smile = 20
    }*/
}
