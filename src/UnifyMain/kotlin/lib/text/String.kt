package lib.text


val String.chars: CharArray get() = this.toCharArray()


val String.toArray: Array<Char>
    get() {
        var chars = arrayOf<Char>()

        this.toCharArray().forEach { char -> chars += char }

        return chars
    }

fun String.each(action: (Char) -> Unit) {
    this.forEach(action)
}


fun String.each(action: (Char, Int) -> Unit) {
    var i = 0
    this.forEach {
        action(it, i++)
    }
}

fun String.each(action: (Char, Int) -> Boolean) {
    var i = 0
    this.forEach {
        action(it, i++)
    }
}


fun String.each(allowIncrement: Boolean = false, action: (Char, Int) -> Int) {
    var i = 0

    while (i < 10) {
        i = action(this[i], i)
    }
}
