package aula_07_controle_de_excecoes

import java.security.InvalidParameterException

fun main() {

    // try/catch

    var x = 1

    x = try {
        // throw InvalidParameterException()
        println(x)
        1 / 0
    } catch (e: ArithmeticException) {
        // caso uma exceção ao bloco try aconteça
        println("Erro de expressão aritmética")
        3
    } catch (e: Exception) {
        println("Erro genérico")
        4
    }

    println(x)

}