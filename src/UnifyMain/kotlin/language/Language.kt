package language


import lib.oop.classes.Class as SClass
import language.ast.TokensStatic
import lib.oop.classes.StaticClass

abstract class LanguageStatic : StaticClass() {

    abstract class Class : SClass<LanguageStatic>() {
        abstract val tokens: TokensStatic.Class
    }
}


