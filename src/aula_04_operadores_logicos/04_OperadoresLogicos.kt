package aula_04_operadores_logicos

fun main() {

    val a = true
    val b = false
    val c = true

    // operador E (&&)
    println("")
    println("E:")
    val result = a && b
    val result2 = a && c

    println(result)
    println(result2)

    // operador OU (||)
    println("")
    println("OU:")
    val result3 = a || b
    val result4 = a || c

    println(result3)
    println(result4)

    // operador NÃO (!)
    println("")
    println("NÃO:")
    val result5 = a
    val result6 = false

    println(result5)
    println(result6)

    val num1 = 10
    val num2 = 5

    // operador IGUALDADE (==)
    println("")
    println("IGUALDADE:")
    println(num1 == num2)

    // operador DESIGUALDADE (!=)
    println("")
    println("DESIGUALDADE:")
    println(num1 != num2)

    // operadores É DO TIPO E NÃO É DO TIPO (is e !is)
    println("")
    val num: Any = 1
    val numText: Any = "1"


    println("Operadores É DO TIPO:")
    println(num is String)
    println(numText is String)

    println("Operadores NÃO É DO TIPO:")
    println(num !is String)
    println(numText !is String)

    // operadores PERTENCE e NÃO PERTENCE (in e !in)
    println("")
    val range = 1..10
    val x = 5
    val y =15

    println("Operadores PERTENCE:")
    println(x in range)
    println(y in range)

    println("Operadores NÃO PERTENCE:")
    println(x !in range)
    println(y !in range)
}