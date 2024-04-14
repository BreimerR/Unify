package unify

import DEBUG_SHOW_TOKENS
import lib.cli.CLIArguments

fun main(args: Array<String>) {
    // initialize arguments
    val cli = CLIArguments(args)

    val unify = Unify(cli)

    System.updateDebug(cli)

    if (DEBUG_SHOW_TOKENS) for (token in unify.tokens.items) println(token)

    Log.d("Unify.main", unify.test())

}
