## Sections

a section is a unit of test. 
a unit is a single instance of existence in a match case
sample

__i.e *check for 'name' inside a string "my name is userName"*__
instance in this case is the word name defined as 

Section("name");[RPE;Y5SPUR76KIOUTYP5I54P5OI38W949O9Y]

on test of this i.e
Section("name").test(Items("my name is userName"))
to test for the whole string defined as

// defines a section that ignores spaces
Section(Section("my"),Section("name"),Section("is"),Section("UserName"),ignore = Section("\s"))


## ZeroOrMany
This is an instance that can either exist or not exist

### @ Problem cases
Always returns true i.e case where 
```kotlin

val section = ZeroOrMany(
    ZeroOrMany(
        Section("name")
    )
)

```

Test case will never stop returns true from every time.

This is a problem as there is no stop position to exit the test case

__problems__
* Test end not definitive 


__solutions__

* Test  if there are no more items in the Items object.
    ```
        1. Exit defined.
        2. Exit not clear as section will get wrong information
        
    ```
  
* Use items index change as an indicator of testable or not
    ```
        1.  This is better as a section change is more validatable than just a boolean variable
        2.  Not tested so no issues related to the solutions have been tested
        3.  No section should test if there are no more items in the Items<T> object
        4.  Still does not define an instance where the section should test again or move foward
        5.  
        10. Use the @RequiresPermission annotation to validate the perfr;'e;g'elg
  
    ```
    

