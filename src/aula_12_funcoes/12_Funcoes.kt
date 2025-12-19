package aula_12_funcoes

fun isEven(num: Int) {
    println("$num é par? ${num % 2 == 0}")
}

fun main() {

    val num = 4

    isEven(num = num)
}