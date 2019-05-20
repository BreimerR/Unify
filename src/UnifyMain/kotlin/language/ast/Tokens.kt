package language.ast


import language.lib.io.File
import lib.oop.classes.Class
import language.tokens.TokenClass
import language.tokens.TokenStatic
import lib.oop.classes.StaticClass
import unify.tokens.characters.TabStatic
import unify.tokens.characters.NewLineStatic


abstract class TokensStatic : StaticClass() {
    abstract val tokenClasses: Array<out Array<out TokenStatic>>
}

abstract class TokensClass : Class<TokensStatic>() {

    abstract override val self: TokensStatic

    abstract val fileName: String

    abstract val fileEncoding: String

    var tokens = arrayOf<TokenClass>()

    init {
        initializeTokens()
    }

    // find tokens
    private fun initializeTokens() {

        val file = File(fileName)

        var line = 1
        var col = 1

        val t = this

        file.open {
            var tk: TokenClass? = null

            while (true) {
                val cI = file.i
                var till = 0

                // pattern recognition starts form here
                factoriesArray@ for (classes in t.self.tokenClasses) {
                    for (klass in classes) {
                        val test = klass test file
                        till = file.i
                        if (test) {
                            val s = file.getString(cI, till)

                            tk = klass(s, line, col)

                            when (klass) {
                                is NewLineStatic -> {
                                    line += 1
                                    col = 1
                                }
                                is TabStatic -> col += 4
                                else -> col += s.length
                            }

                            break@factoriesArray
                        } else file.placeCursorAt(cI)
                    }
                }

                if (tk == null) throw Error("No token declared for ${file.getString(cI, till)}")

                tokens + tk

                tk = null

                if (atEnd) {
                    break
                }

            }
        }
    }
}