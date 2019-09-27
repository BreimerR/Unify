class File:
    mode = None
    fileName = None
    file = None

    def __init__(self, fileName):
        self.fileName = fileName

    def read(self, action):
        if self.file is None:
            self.open("r")

        action(self.file)

    def cursorTo(self):
        pass

    def readWrite(self, action):
        if self.file is None:
            self.open("w+")

        self.file.write(action)
        self.close()

    def open(self, mode="r"):
        if self.file is None:
            self.mode = mode
            self.file = open(self.fileName, mode)

    def append(self, txt):
        self.open("a+")
        for i in range(0, len(txt) - 1):
            self.file.write(txt[i])

    def close(self):
        self.file.close()
        self.mode = None
        self.file = None


cSample = """
package unify.tokens.characters


import unify.tokens.tokens.CharacterStatic

val %s = %sStatic()


class %sStatic : CharacterStatic() {

    override val char = '%s'

    override fun invoke(tokenString: String, l: Int, col: Int): Class = Class(tokenString, l, col)

    class Class(tokenString: String, l: Int, col: Int) : CharacterStatic.Class(tokenString, l, col, %s)
}
"""

oSample = """
package unify.tokens.operators

import unify.tokens.tokens.OperatorStatic


val %s = %sStatic()


class %sStatic : OperatorStatic() {

    override var tokenString: String = "%s"

    override fun invoke(tokenString: String, l: Int, col: Int): Class = Class(tokenString, l, col)

    class Class(tokenString: String, l: Int, col: Int) : OperatorStatic.Class(tokenString, l, col,%s) 
}
"""

operators = {
    "DColon": "::",
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
    "FSlash": "\\",
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
    "BSlash": "/",
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
