package lazy


internal interface Lazy<T> {

    var initializer: (() -> T)?

    val initialized: Boolean;

    var lock: Any?

    infix fun was(boolean: Boolean) = boolean

}




