package lazy


fun <T> mutableLazy(lock: Any? = null, initializer: () -> T): MutableLazy<T> = MutableLazy(lock, initializer)

fun <T> lazy(lock: Any? = null, initializer: () -> T): ImmutableLazy<T> = ImmutableLazy(lock, initializer)