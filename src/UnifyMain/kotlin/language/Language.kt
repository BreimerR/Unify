package language

import language.ast.TokensClass
import lib.oop.classes.Class
import lib.oop.classes.StaticClass

abstract class LanguageStatic : StaticClass()


abstract class LanguageClass : Class<LanguageStatic>() {
    abstract val tokens: TokensClass


}