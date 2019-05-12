package language.ast

import lib.oop.Class
import lib.oop.StaticClass
import language.lib.os.File
import language.tokens.TokenClass
import language.tokens.TokenStatic


abstract class TokensStatic : StaticClass() {
    abstract val tokenClasses: Array<out Array<out TokenStatic>>


}

abstract class TokensClass : Class<TokensStatic>() {

    abstract override val self: TokensStatic

    abstract val fileName: String

    abstract val fileEncoding: String

    var tokens: Array<out TokenStatic> = arrayOf()

    // find tokens
    fun initializeTokens() {

        val file = File(fileName, fileEncoding)

        var line = 1
        var col = 1

        file.open { it: File ->
            var tk: TokenClass? = null
            while (true) {
                val cI = file.i
                var till = 0

                factoriesArray@ for (factories in self.tokenClasses) {
                    for (factory in factories) {
                        val test = factory.test(file)
                        till = file.i
                        if (test) {
                            val s = file.getString(cI, till)

                            tk = factory(s, line, col)

                            when (tk) {
                                is NewLine -> {
                                    line += 1
                                    col = 1
                                }
                                is TabStatic -> col += 4
                                else -> col += s.length
                            }

                            break@factoriesArray
                        } else file.cursorAt(cI)
                    }
                }

                if (tk == null) throw Error("No token declared for ${file.getString(cI, till)}")

                tokens + tk

                tk = null

                if (file.atEnd) {
                    break
                }


            }
        }
    }
}