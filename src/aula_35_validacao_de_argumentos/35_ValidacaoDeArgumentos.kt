package aula_35_validacao_de_argumentos

// require

fun dividir(a: Int, b: Int): Int {
    require(b != 0) {
        "O divisor não pode ser zero."
    } //IllegalArgumentException
    return a / b
}

// requireNotNull

fun imprimirNome(nome: String?) {
    val nomeNaoNulo = requireNotNull(nome) {
        "O nome de usuário não foi definido até o momento."
    } //IllegalArgumentException
    println("Nome: $nomeNaoNulo")
}

// check

fun processarListaNotas(lista: List<Int>) {
    check(lista.isNotEmpty()) {
        "A lista não pode ser processada. Não há nenhum item inserido"
    } // IllegalStateException
    println("Processando lista de tamanho ${lista.size}...")
    check(lista.all { it != 0 }) {
        "O aluno foi reprovado por possuir uma nota 0."
    } // IllegalStateException
    println("A média é ${lista.sum() / lista.size}...")

}

fun main() {

// println(dividir(6,2))
// println(dividir(3,0))

//    imprimirNome("Caio")
//    imprimirNome(null)

    processarListaNotas(listOf(1, 5, 7, 9))
    processarListaNotas(listOf(1, 5, 0, 9))
    processarListaNotas(emptyList())

}