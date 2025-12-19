package aula_18_personalizando_propriedades

import kotlin.math.ceil

class Person(
    val name: String,
) {
    var age: Int = 0
        set(value) {
            if (value >= 0) field = value
            else println("Idade não pode ser negativa.")
        }

    var height: Double = 0.0
        get() = ceil(field)
}

fun main() {

 val joao = Person("Joao")

    joao.age = 30
    joao.height = 175.9

    println(joao.age)
    println(joao.height)

    joao.age = -10

}