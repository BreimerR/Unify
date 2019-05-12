package unify


import lib.fs.DirClass
import unify.ast.Tokens
import language.LanguageClass
import language.LanguageStatic
import lib.cli.CLIArgumentsClass


class UnifyStatic : LanguageStatic() {
    operator fun invoke(args: CLIArgumentsClass): UnifyClass {
        return UnifyClass(args)
    }
}

class UnifyClass(args: CLIArgumentsClass) : LanguageClass() {
    override val tokens = Tokens(args)

    override val self = Unify

    fun translateTo(language: LanguageClass, outPutDir: DirClass) {

    }

}

val Unify = UnifyStatic()