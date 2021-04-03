# Functions

###### **Declaration** 

```
With parameters

<Unify returnType> a(<Unify params>){
	//function body
}

With no parameters

<Unify returnType> a{
	// function body
}
```
#### **Inheritance**
###### Implements
- Parameter order 
- Parameter execution
```
<Unify returnType> foo (<Unify parameters>){
	// available variables are (arguments)
	// function body
}

<Unify returnType> bar : foo(<Unify parameters>,<Unify extendedParameters>){
	// available variables are (result|results) (arguments)
	// function body
}



<Unify returnType> foo{
		// available variables are
	// function body
}

<Unify returnType> bar : foo{
	// available variables are (result)
}

<Unify returnType> bar : foo,perssed {
	// available variables are (results) (arguments)
}
```

#### **Implements**
###### Implements
-  Parameter order 

```
<Unify returnType> foo (<Unify parameters>){
	// available variables are (arguments)
	// function body
}

<Unify returnType> bar ::  foo(<Unify parameters>,<Unify extendedParameters>){
	// available variables are (result|results) (arguments)
	// function body
}

<Unify returnType> foo{
		// available variables are
		// function body
}

<Unify returnType> bar : foo{
	// available variables are (result)
}

<Unify returnType> bar : foo , perssed{
	// available variables are (results) (arguments)
}
```

###### Chain of command inheritance

```
String getFirstName{
	return "Breimer"
}

String getSecondName{
	return "Radido"
}

/// Look into context structutes of this type of functions
String getFullName : getFirstName , getLastName => res + res1;
// Same as
String getFullName{return getFirstName() + getLastName()}
```


###### Default Values 

```
Int divide(Int value,Int divideBy = !0) throws DivisionByZero {
	return value/divideBy
}

Int divide (Int value , Int divideBy){
	if(divideBy == 0){
		throw Error "Division By zero	
	}
	
	return value/divideBy
}

```


###### Final functions;
- This is a function that can not exist anywhere else in the package
```
Int  final setAge(){
	
}
```


```
Toggle functions

class Switch{
	constructor(state){
		this.state = state;
	}
	
	click(){
		if(state == "off"){
			state = "on"
		}else {
			state = "off"
		}
	}
}

$b = new Switch('off)

$b.click()

$b.click()

```




