import lib.cli.CLIArgumentsStatic
import platform.posix.sync
import kotlin.math.min
import kotlin.reflect.KProperty


var DEBUG = false
var DEBUG_PARSERS = false

// allows all testable positive states
var DEBUG_POSITIVES = false

// allows all testable negative states
var DEBUG_NEGATIVES = false

// allow testableSection logs
var DEBUG_SECTIONS = false
var DEBUG_POSITIVE_PARSERS = false

// shows all tokens before test runs
var DEBUG_SHOW_TOKENS = false

// log token debugs
var DEBUG_TOKENS = false

class System {

    companion object {

        fun updateDebug(cli: CLIArgumentsStatic.Class) {
            DEBUG = cli.getBoolean("--debug", false)
            DEBUG_PARSERS = cli.getBoolean("--debug-parsers", false)
            DEBUG_POSITIVES = cli.getBoolean("--debug-positives", false)
            DEBUG_NEGATIVES = cli.getBoolean("--debug-negatives", false)
            DEBUG_SECTIONS = cli.getBoolean("--debug-sections", false)
            DEBUG_POSITIVE_PARSERS = cli.getBoolean("--debug-positive-parsers", false)
            DEBUG_SHOW_TOKENS = cli.getBoolean("--debug-show-tokens", false)
            DEBUG_TOKENS = cli.getBoolean("--debug-tokens", false)
        }


    }


}

class Log {
    companion object {
        val size = 40

        fun d(tag: String, value: Any?) {

            if (DEBUG) {
                var spaces = ""
                for (i in 0 until size - min(size, tag.length)) spaces += " "

                println("$tag:$spaces$value")
            }
        }

        fun e(tag: String, value: Any?) {

        }
    }
}


