package unify.parsers.controlstractures

import language.sections.AlternativeSection

class LoopsParser : AlternativeSection(
    WhileParser(),
    ForParser(),
    DoWhileParser()
)