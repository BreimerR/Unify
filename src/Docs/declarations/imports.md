
// file A.u
class A<T>

// file B.u

class B

// file C.u

import B
import A<B> as A

// this way  every time I have to use A<B> I can just place A and the compiler will know what I am referring  to.

class C : A{

}

// end goal always translating


# Advanced Imports

I have a project structure i.e <br>
-- src<br>
---- lib<br>
------fs<br>
-------- File.u<br>
    
    
I have a file <br/>

--src
----app
------App.u
```unify
import lib.File
class App{
    init{
        $res =  File("src/res/index.ui")
    }
]
``` 

Since lib has only one File.u  file and class it can be said that lib.File is a valid import

