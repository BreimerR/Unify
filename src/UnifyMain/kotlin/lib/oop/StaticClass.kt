package lib.oop


/**Framework Details
 * This should be extended by all classes with static section
 * Or initialized as the class i.e for a class with no static class
 * @method abstract operator fun invoke
 * always implement the invoke method as it is the required for construction
 * invoke should be generated dependant on the constructors that are required
 * by the Class
 * */

abstract class StaticClass {
    infix fun isInstance(obj: StaticClass): Boolean {

        return false
    }
}

