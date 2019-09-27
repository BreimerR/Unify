package lib.matcher

import lib.oop.classes.Class
import lib.oop.classes.StaticClass

abstract class MatchedClass<Type> : Class<MatchedStatic>()


abstract class MatchedStatic : StaticClass()