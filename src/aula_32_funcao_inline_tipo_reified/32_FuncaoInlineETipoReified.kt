package aula_32_funcao_inline_tipo_reified

inline fun executeAction(action: () -> Unit) {
    println("Iniciando a ação...")
    action()
    println("Finalizando a ação...")
}

fun main() {

    executeAction {
        println("Executando ação...")
    }

}