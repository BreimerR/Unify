package language


import lib.oop.classes.Class
import language.ast.TokensStatic
import lib.oop.classes.StaticClass

abstract class LanguageStatic : StaticClass()


abstract class LanguageClass : Class<LanguageStatic>() {
    abstract val tokens: TokensStatic.Class


}