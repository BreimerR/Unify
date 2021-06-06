package lazy

import kotlin.reflect.KProperty

class MutableLazy<T>(lock: Any?, initializer: () -> T) : ImmutableLazy<T>(lock, initializer), Lazy<T> {
    operator fun <R> setValue(receiver: R, property: KProperty<*>, value: T) {
        _value = value
    }
}