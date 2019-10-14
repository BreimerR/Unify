package lib.cli

import lib.math.isEven
import lib.oop.classes.Class
import lib.oop.classes.StaticClass
import lib.collections.array.invoke


class CLIArgumentsStatic : StaticClass() {
    operator fun invoke(arguments: Array<String>): CLIArgumentsClass = CLIArgumentsClass(arguments)
}


class CLIArgumentsClass(arguments: Array<String>) : Class<CLIArgumentsStatic>() {
    override val self = CLIArguments

    var args = mapOf<String, String>()

    init {
        if (arguments.size.isEven) {
            arguments(step = 2) { i: Int, key: String ->
                args += Pair(key, arguments[i + 1])
            }
        }

    }

    operator fun get(key: String): String {
        return args[key] ?: throw Error("Argument $key is not defined")
    }
}

val CLIArguments = CLIArgumentsStatic()