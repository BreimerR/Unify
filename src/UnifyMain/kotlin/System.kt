import lib.cli.CLIArgumentsClass

class System {

    companion object {
        fun updateDebug(cli: CLIArgumentsClass) {

        }

        var DEBUG = false
        var DEBUG_PARSERS = false
        // allows all testable positive states
        var DEBUG_POSITIVES = false
        var DEBUG_POSITIVE_PARSERS = false
        var DEBUG_TOKENS = false
        var DEBUG_SHOW_TOKENS = false
    }
}