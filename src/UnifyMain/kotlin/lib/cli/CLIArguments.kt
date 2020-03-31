package lib.cli

import lib.collections.array.invoke
import lib.math.isEven
import lib.oop.classes.StaticClass
import lib.oop.classes.Class as OopClass


class CLIArgumentsStatic : StaticClass {
    operator fun invoke(arguments: Array<String>): Class = Class(arguments)

    class Class(arguments: Array<String>) : OopClass<CLIArgumentsStatic>() {
        override val self = CLIArguments

        var args = mapOf<String, String>()

        init {
            if (arguments.size.isEven) {
                arguments(step = 2) { i: Int, key: String ->
                    args += Pair(key, arguments[i + 1])
                }
            }

        }

        fun getBoolean(key: String, default: Boolean? = null): Boolean {
            return args[key]?.toBoolean() ?: default ?: throw Error("Argument $key is not defined")
        }

        fun getString(key: String, default: String? = null): String {
            return args[key] ?: default ?: throw Error("Argument $key is not defined")
        }

        fun getInt(key: String, default: Int? = null): Int {
            return args[key]?.toInt() ?: default ?: throw Error("Argument $key is not defined")
        }

        operator fun get(key: String): String {
            return args[key] ?: throw Error("Argument $key is not defined")
        }
    }
}


val CLIArguments = CLIArgumentsStatic()