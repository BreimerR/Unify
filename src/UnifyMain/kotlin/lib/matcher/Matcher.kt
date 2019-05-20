package lib.matcher

import lib.oop.classes.Class
import lib.oop.classes.StaticClass

abstract class MatcherStatic : StaticClass()

abstract class MatcherClass<Self : MatcherStatic> : Class<Self>()
