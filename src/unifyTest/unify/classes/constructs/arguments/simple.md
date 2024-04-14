Changes made inside the method scope affect changes outside the method.
i.e
```Unify
var age = 12
func changeAge(internal val age){
    age = 20
}
changeAge(age)
println(age)
```

Changes made inside the method do not affect the variable outside this scope

descriptions
internally scoped parameter
externally scoped parameter
internally scoped mutable parameter
could just have var and val
in the sense var means that  the variable passed is expected to be mutable
and changes made to in inside the method will reflect changes made to it outside the method.
This should also apply to objects.
val being variables that are passed to a method and can not be changed inside the method
one case is not accounted for
case where the argument is a var but not mutable
or a var that you only want to make changes to inside the method could employ
syntax sugar i.e copy reference variables creating a copy of the argument and using that i.e

```Unify
var name = "breimer"

func age(copy var name){
    name = "steve"
    println(name) // steve
}
//
println(name) // breimer
```
A more efficient way is to have
```Unify

var name = "breimer"

func age(let name){
    name = "steve"
    println(name) // steve
}
println(name) // breimer
```

let creates a copy of the provided argument and uses that in
it's memory scope and not externally This is could ripple to external space by
providing better scoping where

```let name = "breimer"```
name will only be 

# Known Variable Scopes
## Rules
Scopes provided for the variable will be the default for passing in a method
```Might bring a bit of a confusion while working``` but this can be overridden 
by providing the scoping in method declaration
#### File scope  


```Unify
var name = "breimer"
func changeName(name){
    name = "Steve"
}
changeName(name)
println(name) // Steve
```
The above has description redundancy
i.e name is var and defined as name again as var and changes main name i.e it 
is exactly the same as
```Unify
var name ="breimer"

func changeName(){
    name ="Steve"
}
changeName(name)
println(name) // Steve
```
#### Project scope
```Unify
global var name ="breimer"

func changeName(name){
    name = "Steve"
}
changeName(name)
println(name) // Steve
```
This will be shadowed with import statements i.e 
```Unify
import name from Unify.x as name
```
#### Method Scope
#### Class Scope


## Access and Mutability Modifiers
#### let
```Unify
let var name = "Breimer"
func changeName(let var name){
    name = "Steve"
    println(name) // Steve

}
changeName(name)
println(name) // Breimer
```

```Unify
let val name = "Breimer"
func changeName(let var name){
    name = "Steve"
    println(name) // Steve

}
changeName(name)
println(name) // Breimer
```
### var
```Unify
var name = "Breimer"

func changeName(name){
    name = "Emily"
}
changeName(name)
println(name) // Emily
```
### val
```Unify
val name = "Breimer"

func changeName(name){
    name ="Smile" // Should error
    println(name) // Breimer
}
changeName(name)
println(name) // Breimer
```