package lib.collections.array


infix fun Array<String>.joinBy(separator: String): String {
    return this.joinToString(separator)
}

val <T> Array<T>.length: Int
    get() {
        return this.size
    }


// an iterator function should be able to break
// find a way to introduce the concept
fun <T> Array<T>.each(start: Int = 0, action: (T) -> Unit) {
    for (i in start until size) {
        action(this[i])
    }
}

fun <T> Array<T>.each(start: Int = 0, action: (Int, T) -> Unit) {
    for (i in start until size) {
        action(i, this[i])
    }
}

fun <T> Array<T>.each(start: Int = 0, action: (Int, T) -> Array<T>) {
    for (i in start until size) {
        action(i, this[i])
    }
}

fun <T> Array<T>.each(start: Int = 0, step: Int = 1, action: (Int, T) -> Unit) {
    for (i in start until size step step) {
        action(i, this[i])
    }
}

operator fun <T> Array<T>.invoke(start: Int = 0, func: (T) -> Unit) {
    this.each(start, func)
}

operator fun <T> Array<T>.invoke(start: Int = 0, step: Int = 1, func: (T, Int) -> Unit) {
    this.each(start, step) { i: Int, item: T ->
        func(item, i)
    }
}

operator fun <T> Array<T>.invoke(start: Int = 0, step: Int = 1, func: (Int, T) -> Unit) {
    this.each(start, step, func)
}


operator fun <T> Array<T>.minus(i: Int): Array<T> {
    return this.copyOfRange(0, i)
}

operator fun <T> Array<T>.minusAssign(i: Int) {
    minus(i)
}

operator fun <T> Array<T>.get(intRange: IntRange): List<T> {
    return intRange.map {
        this[it]
    }
}

fun <T> Array<T>.pop(): Array<T> = minus(1)