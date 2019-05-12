package language.parsers.declarations

import lib.oop.Class
import lib.oop.StaticClass


abstract class DeclarationStatic : StaticClass()

abstract class DeclarationClass : Class<DeclarationStatic>()
