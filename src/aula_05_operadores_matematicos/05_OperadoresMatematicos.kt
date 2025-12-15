package aula_05_operadores_matematicos

import kotlin.math.ceil
import kotlin.math.floor
import kotlin.math.log10
import kotlin.math.pow
import kotlin.math.roundToInt

fun main() {

    val num = 4
    val num2 = 2

    //básicos
    println("")
    println("Operadores básicos:")

    println(num + num2)
    println(num - num2)
    println(num * num2)
    println(num / num2)
    println(num % num2)

    //incremento

    println("")
    println("Incremento/Decremento:")

    var num3 = 10
    var num4 = 20
    num3++
    num4--

    println(num3)
    println(num4)

    // atribuição composta
    println("")
    println("Atribuição composta:")

    var num5 = 1

    num5 += num // soma
    num5 -= num // subtração
    num5 *= num // multiplicação
    num5 /= num // divisão
    num5 %= num // resto da divisão

    println(num5)

    // biblioteca math
    println("")
    println("Biblioteca Math:")

    val value = 2.567
    val valueRounded = value.roundToInt()

    println(valueRounded)

    val valueCeil = ceil(value)

    println(valueCeil)

    val valueFloor = floor(value)

    println(valueFloor)

    val base = 2.0
    val exponent = 3.0

    val valuePow = base.pow(exponent) // 2 ^ 3 = 2 * 2 * 2 = 8

    println(valuePow)

    val logValue = log10(100.00)

    println(logValue)

}