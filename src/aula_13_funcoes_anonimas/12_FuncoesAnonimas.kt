package aula_13_funcoes_anonimas

fun main() {

    var sum = 2 + 2

    val funSum = { a: Int, b: Int -> {
            sum = 100
            a + b
        }
    }

    println(funSum(1, 2).invoke())
    println(sum)

}