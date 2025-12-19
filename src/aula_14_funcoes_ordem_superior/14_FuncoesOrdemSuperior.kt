package aula_14_funcoes_ordem_superior

fun sum(a: Int, b: Int): Int = a + b

fun subtract(a: Int, b: Int): Int = a - b

fun multiply(a: Int, b: Int) = a * b

fun mathOperation(a: Int, b: Int, operation: (Int, Int) -> Int) : Int {
    return operation(a, b)
}

fun main() {

    val divide = { a: Int, b: Int -> a /b }

    println(mathOperation(a = 10, b = 5, operation = ::sum))
    println(mathOperation(a = 10, b = 5, operation = ::subtract))
    println(mathOperation(a = 10, b = 5, operation = ::multiply))
    println(mathOperation(a = 10, b = 5, operation = divide))

}