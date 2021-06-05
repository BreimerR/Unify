
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