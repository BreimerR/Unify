package lib.text


val String.chars: CharArray get() = this.toCharArray()


val String.toArray: Array<Char>
    get() {
        var chars = arrayOf<Char>()

        this.toCharArray().forEach { char -> chars += char }

        return chars
    }