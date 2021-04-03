#Objects

- Everything in Unify is an object even functions
- This allows us to give functions the ability to be extended|inherited and implemented like interfaces


### Simple Objects
#### Declaration

```
	$b = {
		<UnifyParameterName>: value <Unify optionalObjectSeparation character (,)>
		`$<Unify parameterName>` : value
	}
	// Back end conversion
	Object  b = {
		
	}
```

##### Getters & Setters

- Objects have default getters and setters

###### Getter

```
$b = {
	n: value
	get name(accessKey){
		if(accessKey === "Breimer"){
			return this.n
		}
	}
	age
	places :value
	__setter(name,value){
		log('Some function is changing the value of a')
		this.$name = value
	}
}

// Backend structure
Object b = {
	name:value,
	age: null,
	places:vaue
	
}
```





