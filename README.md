# Unify

A Language made to be simple and as self explanatory as possible. This is to be the base of the
project as to reduce
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


###### References
https://youtube.com/watch?v=wgHIkdUQbp0&list=PLRAdsfhKI4OWNOSfS7EUu5GRAVmze1t2y##
