package aula_09_inicializacao_tardia

import kotlin.properties.Delegates

fun main() {

    // lateinit

    lateinit var a: String

    // ...

    a = "kotlin lateinit"

    println(a)

    /// lazy

    val b: String by lazy {
        "kotlin lazy"
    }

    println(b)

    var c: Int by Delegates.notNull()
    var d: Boolean by Delegates.notNull()
    var e: Double by Delegates.notNull()

    c = 10

    println(c)

}