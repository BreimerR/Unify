package lazy

import kotlin.reflect.KProperty

open class ImmutableLazy<T>(lock: Any? = null, initializer: () -> T) : Lazy<T> {

    @Suppress("PropertyName")
    protected var _value: T? = null

    override var lock: Any? = lock ?: Any()

    override var initializer: (() -> T)? = initializer

    override val initialized: Boolean
        get() = initializer == null || lock == null

    @Suppress("UNCHECKED_CAST")
    var value: T
        get() = if (this was initialized) {
            _value as T
        } else {
            val v: T = initializer!!()

            lock = null
            initializer = null

            _value = v

            v
        }

        set(value) {
            _value = value
        }


    operator fun getValue(t: Any?, property: KProperty<*>): T = value


}