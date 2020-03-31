package unify.parsers

import language.parsers.ParserStatic
import unify.tokens.tokens.EOF

class EOFParser : ParserStatic(
        EOF
){
    override val TAG ="EOFParser"
}

