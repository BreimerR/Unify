package unify.parsers.variables

import language.parsers.ParserStatic
import unify.parsers.TerminatorParserPartial

class TVariableDeclarationParser : ParserStatic(
        VariableDeclarationParser(),
        /** @Description
         * This should be the one used as EndsWith looks for an end but walk all over whatever is it and the end
         * termination means that there can not be an expression filling upto two lines as
         * this is true with most languages
         * else there has to be a definitive termination rather than just a new line but something like a ; or else
         * more complex code would be required for the parser to work
         **/
        TerminatorParserPartial()
)