from File import File

cSample = """package unify.tokens.characters

import unify.tokens.tokens.CharacterStatic

class %sStatic : CharacterStatic() {

    override val char = '%s'

    override fun invoke(tokenString: String, l: Int, col: Int): Class = Class(tokenString, l, col)

    class Class(tokenString: String, l: Int, col: Int) : CharacterStatic.Class(tokenString, l, col, %s)
}

val %s = %sStatic()
"""

oSample = """package unify.tokens.operators

import unify.tokens.tokens.OperatorStatic

class %sStatic : OperatorStatic() {

    override var tokenString: String = "%s"

    override fun invoke(tokenString: String, l: Int, col: Int): Class = Class(tokenString, l, col)

    class Class(tokenString: String, l: Int, col: Int) : OperatorStatic.Class(tokenString, l, col,%s) {
        override fun testItem(item: ItemStatic.Class<String>?): Boolean {
            return if (item != null)
                item is Class
            else false
        }
    }
}

val %s = %sStatic()
"""

operators = {
    "Ellipsis": "...",
    "DColon": "::",
    "OrOperator": "||",
    "AndOperator": "&&",
    "DoOperator": "->",
    "ElvisOperator": "?:",
    "MinusEquals": "-=",
    "MlCommentEndOperator": "*/",
    "MLCommentOperator": "/*",
    "NotEqual": "!=",
    "PlusEquals": "+=",
    "ReturnOperator": "=>",
    "SCommentOperator": "//",
    "TimesEquals": "*="

}
skippedChars = {
    "FSlash": "/",
    "SQuotes": "'",
    "NewLine": "n",
    "EscapedR": "r",
    "Tab": "t"
}

characters = {
    "Asterisk": '*',
    "SLine": "~",
    "BTick": "`",
    "Exclamation": "!",
    "At": "@",
    "Hash": "#",
    "Dollar": "$",
    "Percent": "%",
    "UCaret": "^",
    "Ampersand": "&",
    "LBracket": "(",
    "RBracket": ")",
    "Underscore": "_",
    "Plus": "+",
    "Minus": "-",
    "Equals": "=",
    "LBrace": "{",
    "LSBracket": "[",
    "RBrace": "}",
    "RSBracket": "]",
    "Pipe": "|",
    "Colon": ":",
    "Space": " ",
    "SColon": ";",
    "LThan": "<",
    "GThan": ">",
    "Coma": ",",
    "Dot": ".",
    "BSlash": "\\",
    "Question": "?"
}


def processChars(chars, action):
    for name in chars:
        value = action(chars[name])
        src = "../UnifyMain/kotlin/unify/tokens/characters/"
        file = File(src + name + ".kt")
        file.readWrite(format(cSample % (name, name, name, value, name)))


def processOperators(ops):
    for name in ops:
        src = "../UnifyMain/kotlin/unify/tokens/operators/"
        file = File(src + name + ".kt")
        file.readWrite(format(oSample % (name, name, name, ops[name], name)))


def createChars(chars):
    processChars(chars, lambda v: v)


def createSkippedChars(chars):
    processChars(chars, lambda v: "\\" + v)


createChars(characters)
createSkippedChars(skippedChars)
processOperators(operators)
