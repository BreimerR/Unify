# Unify

A Language made to be simple and as self explanatory as possible. This is to be the base of the project as to reduce 
the learning curve, and maintain runtime speed of other competitive languages.

Use the following Gradle commands
* to build: `sh ./gradlew assemble`
* to test: `sh ./gradlew check`
* to run:  `sh ./gradlew runHelloWorldAppReleaseExecutableHelloWorld`

# Design
                Array<TokenClasse>  <- Plus,Minus,Identifier...
                        |
     Code    ->      Language       <- Array<ParserClass> <- StringParser,CommentParser...
                        |
                ReferenceResolution
                        |
                       I.R 
                        |
     Kotlin   <-  CodeConverter     -> Javascript
                        | 
                     ByteCode

# On the fly properties declaration for 
```
 BottomSheetBehavior.from(it)
                .addBottomSheetCallback(object : BottomSheetBehavior.BottomSheetCallback() {
                    override fun onSlide(bottomSheet: View, slideOffset: Float) {
                        val max = view?.height?.toFloat() ?: 0F
                        val changeFactor: Float
                        // want to be able to cache x inside this object in order to not 
			// recalculate the value on the next function call 
                        val x = slideOffset / max


                    }

                    override fun onStateChanged(bottomSheet: View, newState: Int) {

                    }

                })
```
