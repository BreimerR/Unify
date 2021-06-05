# Unify Variable declaration
// declare a variable of type any
$a
// declare a variable of type int
$a = 12
// declare a variable with assigned value
$a Int = 12
// declare a constant variable
$a const Int  = 12
// declare a variable with pre assign test and throws error on assignment failure
$a Int : > 0 "A MUST be greater than  0"
// declare a variable with pre assign test and prints error instead
$a(1) Int : > 0 "A MUST be greater than  0"
// declare variable with pre assign test and print error with pre assigned value
$a(1) Int : > 0 "A MUST be greater than  0" = 12

# Parts
name
mutabilityState(const,readonly,readWrite)
type
value



