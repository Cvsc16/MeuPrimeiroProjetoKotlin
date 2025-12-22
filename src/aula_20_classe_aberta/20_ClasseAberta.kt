package aula_20_classe_aberta

open class Animal(
    val name: String,
) {

    open val age: Int = 0

    open fun sound() {
        println("$name: som")
    }

}

class Dog(override val age: Int) : Animal(name = "Cachorro") {

    override fun sound() {
        println("$name: AU AU!")
    }

}

fun main() {

    val dog = Dog(age = 8)

    dog.sound()
    println(dog.age)

}