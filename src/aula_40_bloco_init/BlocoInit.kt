package aula_40_bloco_init

class Pessoa(
    val nome: String,
    val idade: Int,
) {

    init {
        require(nome.isNotBlank()) { "Nome não pode ser vazio "}
        println("Pessoa criada: $nome, $idade anos")
    }

    init {
        println("Pessoa criada: $nome, $idade anos 2")
    }

}

class Carro(
    val marca: String,
    val modelo: String,
) {
    var ano: Int = 0

    init {
        println("Inicializando carro: $marca, $modelo")
    }

    constructor(marca: String, modelo: String, ano: Int) : this(marca, modelo) {
        this.ano = ano
        println("Ano do carro definido: $ano")
    }

}

fun main() {

    // val Ana = Pessoa("",18)

    val uno = Carro("Fiat", "Uno", 1998)

}