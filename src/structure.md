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