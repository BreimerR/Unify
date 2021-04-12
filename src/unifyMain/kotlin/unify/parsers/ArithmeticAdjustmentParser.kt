package unify.parsers

import language.parsers.AlternativeParser



// This does not cater for strings and other data types.
// Might not be a best fit symbol for what it does
//TODO this is misplaced so far not sure if it fits as an expression or an assignment
open class ArithmeticAdjustmentParser : AlternativeParser(
    IncrementalParser(),
    DecrementalParser(),
)

