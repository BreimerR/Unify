# Action Statements
an action is a function that does not contain any parameters 

sample


action simpleActionName{
   
}

## Issues
this structure is nice though the call pattern for actions and variable getters or functin calls
is not well decided and might be pointless to declare like so

```Unify
class Foo{
    action delete:Boolean{
    
    }
}

val foo = new Foo()

// not clear if this is a getter or an action execution
foo.delete

// this is also not quite succesfull
foo->delete 

// this is more reasonable but the use case of this requires implementation of a more robust expression parser as
// this is like a prefix function and prefix and infix functions currently are not working fine or 
// even make for logical conclusions
delete foo;
```
