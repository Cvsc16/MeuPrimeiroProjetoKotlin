package desafios

import desafios.ClassificacaoIMC.Companion.gerarClassificacao
import kotlin.math.pow

//fun main() {
//
//    val peso = readDouble("Digite o seu peso (kg): ")
//    val altura = readDouble("Digite a sua altura (m): ")
//
//    if (peso == null || altura == null || peso <= 0.0 || altura <= 0.0) {
//        println("Entrada inválida. Informe números maiores que zero.")
//        return
//    }
//
//    val imc = calculaIMC(peso, altura)
//
//    println("O seu IMC é: ${"%.2f".format(imc)}, você se encontra na faixa: ${classificaIMC(imc)}")
//
//}
//
//private fun readDouble(msg: String): Double? {
//    print(msg)
//    return readlnOrNull()?.replace(',', '.')?.toDoubleOrNull()
//}
//
//fun calculaIMC(peso: Double, altura: Double): Double = peso / (altura * altura)
//
//fun classificaIMC(imc: Double): String = when {
//    imc < 18.5 -> "Abaixo do peso"
//    imc < 25.0 -> "Peso normal"
//    imc < 30.0 -> "Sobrepeso"
//    imc < 35.0 -> "Obesidade Grau I"
//    imc < 40.0 -> "Obesidade Grau II"
//    else -> "Obesidade Grau III"
//}

fun main() {

    println("Bem vindo ao Cálculo de IMC!")
    println("Informe o seu peso (em kg):")
    print("-> ")

    val peso = readlnOrNull()?.toDoubleOrNull()

    if (!validarPeso(peso)) {
        println("O valor de peso inserido é inválido")
        return
    }

    println("Informe a sua altura (em m):")
    print("-> ")
    val altura = readlnOrNull()?.toDoubleOrNull()

    if (!validarAltura(altura)) {
        println("O valor da altura inserida é inválido")
        return
    }

    val imc = calculaIMC(peso!!, altura!!)

    val classificacaoIMC = gerarClassificacao(imc)


    println("O seu IMC é: ${"%.1f".format(imc)} e a sua classificação é '${classificacaoIMC.descricao}'.")
}

fun validarPeso(peso: Double?): Boolean =
    !(peso == null || peso <= 0.0)

fun validarAltura(altura: Double?): Boolean =
    !(altura == null || altura <= 0.0)

fun calculaIMC(peso: Double, altura: Double): Double = peso / altura.pow(2)

fun classificaIMC(imc: Double): String {

    return when {
        imc < 18.5 -> "Abaixo do peso"
        imc < 25.0 -> "Peso normal"
        imc < 30.0 -> "Sobrepeso"
        imc < 35.0 -> "Obesidade Grau I"
        imc < 40.0 -> "Obesidade Grau II"
        imc > 39.9 -> "Obesidade Grau III"
        else -> "Desconhecido"
    }
}

enum class ClassificacaoIMC(val descricao: String) {
    DESCONHECIDO("Desconhecido"),
    ABAIXO_DO_PESO("Abaixo do peso"),
    PESO_NORMAL("Peso normal"),
    SOBREPESO("Sobrepeso"),
    OBESIDADE_GRAU_I("Obesidade grau I"),
    OBESIDADE_GRAU_II("Obesidade grau II"),
    OBESIDADE_GRAU_III("Obesidade grau III");

    companion object {
        fun gerarClassificacao(imc: Double): ClassificacaoIMC {
            return when {
                imc < 18.5 -> ABAIXO_DO_PESO
                imc < 25.0 -> PESO_NORMAL
                imc < 30.0 -> SOBREPESO
                imc < 35.0 -> OBESIDADE_GRAU_I
                imc < 40.0 -> OBESIDADE_GRAU_II
                imc > 39.9 -> OBESIDADE_GRAU_III
                else -> DESCONHECIDO
            }
        }
    }
}
