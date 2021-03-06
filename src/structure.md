

# UNIFY

### Simple compiler for unify language created in kotlin-native


## Functions

- Simple function declaration
    ```
    func main(){
        // function body
    }
    ```
- Function with argument
    - by default an argument is not mutable as the language is to at most pass values by reference
    ```
    func main(String[] args){
        // function body
    }
    ```

- Function with mutable argument
    - This it not to mean that the language uses mutable arguments but we want to reduce the work of recreating the variable in some instances
    ```
    func main(var String[] args){
    
    
    }
    ```
    ```
    func String processName(var String name){
        name = ucFirst(name)
        
        return if(validateName(name)){
            name
        } else throw "Name Was not valid"
    }
    ```
- argument less functions 
    ```Unify
    func main{
    
    }
    ```

- function with a return type value
    ```Unify
    func Boolean main => false
    ```
- non-body no return function
    ```Unify
    func main(String name) -> name = "user"
    ```
 
- non typed argument defaults to null type
    ```Unify
    func main(name){
        name
    }
    ```

- destructed values arguments
   ```Unify
    func User buildPerson({String name,Int age,String password})
            => User(name,age,passwor)
   ```
  
- collection destruction
    ```Unify
        func parse(String[] tokens:[...names]) 
   ```


# Variables 

## Declaration
Variable declaration is defined by assignment statement i.e
```Unify
name = "Breimer"
```

### Type Inference
Types of variables are defined from the end value after the assignment operator
or by explicit definition of the type required
```Unify 
// both sample codes are the same.
String name =  "Breimer"
name = "Breimer"
```

### Default values
Default values are defined for instances when a set fails to avoid throwing error

```Unify
String email: "user@email.com"

// throws error but error is contained with default email address
email = 12
```
default values can also be used to declare variables
```Unify
// use default stracture to define variables
name:"Brimer"
```

### Fixed Alternative values or Validator

#### Alternative values
A variable whose value can be either of the alternatives
```Unify

// use fixed alternative valies to declare variables
gender :: 'M'|'F'

```

Trying to set the value with value outside the alternatives will throw an error
```Unify
gender :: 'M'|'F'

// throws error 
gender = 'D'
```

You can use default values together with fixed alternatives to get error handling from fixed type errors

```Unify
gender: 'M' :: 'M'|'F'

// throws error but handled with the default value
gender = 'D'
```
##### Alternative testCases
age : 10 :: > 20 | < 100

#### Validator
This is for cases you would want to validate the value before assigning it

##### Function validator
```Unify
age : 18 :: validateAge
```

##### Right Hand expression validation
```Unify
String email :: matches /regularExpression/
// or
age : 18 :: >= 18
```

###### Syntax

Identifier (Colon Variable)? (DColon [RightHandExpression|Identifier])? 

## Variable declaration syntax

TypeDeclaration? Identifier (Colon Variable)? (DColon [RightHandExpression|AlternativeValue|Identifier])? 



###### ___NB___
Thrown errors are not all valid to be rescued by a default value 

```Unify

gender :'M' :: 'M' | 'F'

// this should thrown a compiler error
// type deference 
// but in case for runtime situation the error is not yet decided upon on an approach
// consume the error and set to M
// or throw TypeError
gender = "Breimer"

```


## Class 

```Unify
class Foo{

}
```

### Internal Classes

```Unify
class Foo{
    class Bar{

    }
}
```

#### Internal instance classes
Feature not well organised but to be looked into 

```Unify
class User{
    
    instance class Gun{
           
    }
}

user = new User()

new user.Gun()


```



## Abstraction
### Abstract Classes

```Unify

abstract class User{
    
}

```
### Interfaces

```Unify
interface Foo{
    speedUp()
}

// impl
class Bar :: Foo {
    
    // differentiate between first implementation and override of a function
    impl speedUp(){
        
    }
}
```

#### Generic classes


```Unify

class  Foo<V>{

}
```

### Generic type in nested classes
- A type used by master class will be available for the children clases
    ```Unify
    class Foo<T>{
        
        // T is available for V to use as inherit from
        class Bar<V : T>{
            
            // V used below makes sense
            class FooBar<U : V>{
                    
            }
        }
    }  
  
    // TODO
    // T is not describable as an interface or class
    class Foos<T>{
        
        class Bar<V :: T>{
  
        }
    } 
    ```
  
 ### If
 
 
 ```Unify
if(Boolean){

} 
```

#### Else

```Unify
if(Boolean){

} else{

}
```

#### Else if

```Unify
if(Boolean) {

} else if(Boolean){

}
```


## Loops

#### Mixed Type loops

In a case where there are different type items in a single array we can have 
type selective loops i.e
```Unify
// two typed array
Array<Int,String> array = ["",2]

for Int i in array{
    println i
}


/** result print
2
*/
```


## language compile directives 
## compile modes
1. strict  ```This provides for required val or var declaratios```
2. non strict ```This provides the freedom to leave out val and var in declarations thus providing language flexibility ```


## Getters and Setters
```

data class Person(val name:String, var age:Int){
    age@set(age:String){
        field = age.toString()
    }
}

```


## Use annotation for language processing
This way it means that is one can extend an annotation then one can change 
the language structure to fit their current situation or needs 

This would mean that each section would have a default annotation processor 
and if an annotation is provided then that is considered as the processor of the section or more like the
translator from Unify to the target language 

## Comparison 
This is to be handled by the main Comparator class the shall be extened to handle most cases 

#### Design
###### If
```
val value = false

if(value == false){
}

// this will compare the value to all the provided or states i.e false or true
if (value == false || true){

}

val a = 1

// The prefered syntax is as provided
if(a == 1 || b || c|| d || x ...){

}


```

#### Scope less classes
This are classes that have no specified scope and require a scope on initilization
basically they are function holders and properties that do not pertain to it's super class

```

class Foo(val manager:FooInterface) :: FooInterface by manager{
    val height = 0
    val width = 1
}


delegatable<ScopeCanGoHere> interface FooInterface

// scope provided to the class as so 
class Manager scope Foo {

    val property = "This property does not belong to the super class"

    fun processHeightWidth(){
        height = 12
        width = 20
    } 

}

// or 
delegatable<ScopeCanGoHere> class  Manager  : FooInterface {
    
    fun processHeight(){
        height = 12
        width = 20
    }
}

```

This are proposed features and not well thought of more thinking can be done before implementing 
such features into the final compiler


# Passing operators to functions 
func sample(a,b,operator){
    return a operator b
}
## issues
operators are compiled at compile time and this might be 
hard to achieve with compile time