package language.ast

import lib.oop.classes.Class
import lib.oop.classes.StaticClass

abstract class StatementsStatic : StaticClass()

abstract class StatementsClass : Class<StatementsStatic>()
