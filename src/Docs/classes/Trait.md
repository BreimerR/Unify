# Trait Classes
- This is like an interface but can define method bodies
- They can inherit a class and can also inherit an interface
- They can not be initialized as a class

```
interface A{
	$age
}

trait A :: A{
	$age
	
	__setter(name, value){
		 when {
		 	name ->
		 	"breimer": {
		 	
		 	}		 
		 	" ": {
		 		
		 	}
		 }
	}
	
	// if it is one value private
	
	private String name{
			
	}
	
}

trait B: A{
	__setter(String name, value){
    		 when(name){
    		 		"age":{
    		 			//  what to do
    		 		}
    		 		"place" : {
    		 			// what to do
    		 		}
    		 		
    		 		"sets": {
    		 			// what to do
    		 		}
    		 }
    	}
}

// Trait usage
class C use A{

}

// Use multiple traits
trait D{

}

trait E{

}

clas F use D,E{
	
}
```

##### Diamond problem solution
```
trait A{
	eat{
	
	}
}	

trait B{
	eat{
		
	}
}

// Preference of eat will be based of the first used trait i.e 
// A in this case
class C use A,B{
	
}


$c = C()

$c.eat();
```

######## Solution on different parameter order or types
 - Applies simple function overloading
```
trait A{
	eat(Herbs herb){
	
	}
}	

trait B{
	eat(Meat meat){
		
	}
}

class Meat{

}

class Hearbs{

}

// In this case the call will be based of the parameter provided
class C use A,B{
	
}


$c = C()
// This refrences B.eat()
$c.eat(new Meat());

$c.eat(new Herbs())
```