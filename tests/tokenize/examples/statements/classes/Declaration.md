# Classes Declaration

### Declaration
###### _Simple class_
```
class A{
	// <Unify class Body>
}
```
###### _Without a body_

###### _ Class with one method
```
class A 
	name (){
		
	}
```
```
class A
```

##### Final class

```
// This we use finalize an open class
final class A : B;

// delcaring a simpel final class;
final class B{

}
```

##### Class Inheritance

```
class A{
	// <Unify class body> 	
}

class B: A{
	// <Unify class body> 
}
```

###### Class initialization
- A class initialization must have a new this is best for readability 
yes syntactical sugar is required and at somepoint too much sugar makes no sense
i.e 

###### __Required structure__

```
class A{

}

$b = new A()
```

```
class A{

}

A{
	
}

// Yes it is possible to tare this two appart upto some level of desernment
// but as you read through source code it will be imposible to decern oif 
this is a function call or  a class initialization
$a =  A()

$a =  A()
```


