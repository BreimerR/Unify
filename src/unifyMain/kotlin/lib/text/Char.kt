package lib.text


val kotlin.Char.asString: String
    get() = this.toString()

val kotlin.Array<Char>.asString: String
    get() {
        var string = ""

        for (i in 0 until size) {
            string += this[i]
        }

        return string
    }