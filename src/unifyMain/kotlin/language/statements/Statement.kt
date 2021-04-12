package language.statements

import lib.oop.classes.Class
import lib.oop.classes.StaticClass

abstract class StatementStatic : StaticClass

abstract class StatementClass : Class<StatementStatic>()
