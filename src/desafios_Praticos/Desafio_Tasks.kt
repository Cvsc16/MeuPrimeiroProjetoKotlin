package desafios_Praticos

import java.time.LocalDateTime

sealed class OperationResult {
    data class Success(val message: String) : OperationResult()
    data class Error(val message: String) : OperationResult()
}

data class Task(
    val id: Int,
    val title: String,
    val description: String?,
    val isCompleted: Boolean,
    val createdAt: LocalDateTime,
) {
    companion object {
        private var nextId: Int = 1

        fun create(title: String, description: String?): Task {
            require(title.isNotBlank()) { "Título não pode ser vazio" }

            val generatedId = nextId
            nextId++

            return Task(
                id = generatedId,
                title = title,
                description = description,
                isCompleted = false,
                createdAt = LocalDateTime.now()
            )
        }
    }

    fun toFormattedString(): String =
        "ID: $id | Título: $title | Concluído: $isCompleted | Criado em: $createdAt"
}

class TaskManager() {
    private val listaDeTasks = mutableListOf<Task>()

    fun adicionarTask(task: Task): OperationResult {
        listaDeTasks.add(task)
        return OperationResult.Success("Tarefa adicionada com sucesso! ID: ${task.id}")
    }

    fun listarTasks(): List<Task> {
        return listaDeTasks.toList()
    }

    fun listarTodasTasks(): List<Pair<String, Boolean>> {
        return listaDeTasks.map { Pair(it.title, it.isCompleted) }
    }

    fun buscarTaskResult(id: Int): OperationResult {
        if (id <= 0) return OperationResult.Error("ID inválido")
        val task = listaDeTasks.find { it.id == id }

        return if (task == null) {
            OperationResult.Error("Não foi encontrada a tarefa $id")
        } else {
            OperationResult.Success(task.toFormattedString())
        }

    }

    fun excluirTask(id: Int): OperationResult {
        if (id <= 0) return OperationResult.Error("ID inválido")

        val indexTask = listaDeTasks.indexOfFirst { it.id == id }
        if(indexTask == -1) return OperationResult.Error("Não foi encontrada a tarefa $id")

        listaDeTasks.removeAt(indexTask)

        return OperationResult.Success("Tarefa com ID $id removida com sucesso")
    }

    fun completarTask(id: Int): OperationResult {
        if (id <= 0) return OperationResult.Error("ID inválido")

        val indexTask = listaDeTasks.indexOfFirst { it.id == id }
        if(indexTask == -1) return OperationResult.Error("Não foi encontrada a tarefa $id")

        val task = listaDeTasks[indexTask].copy(isCompleted = true)

        listaDeTasks[indexTask] = task

        return OperationResult.Success("Status da tarefa ID $id atualizado para true")
    }

    fun filtrarTarefasConcluidas(): List<Task> {
        return listaDeTasks.filter { it.isCompleted }
    }

    fun filtrarTarefasPendentes(): List<Task> {
        return listaDeTasks.filter { !it.isCompleted }
    }

    fun count(): Int = listaDeTasks.size

}

fun Int?.isNullOrNegative(): Boolean {
    return this == null || this <= 0
}

enum class AcoesMenu {
    DESCONHECIDA,
    ADICIONAR_TAREFA,
    LISTAR_TAREFA,
    BUSCAR_TAREFA,
    ATUALIZAR_STATUS_TAREFA,
    EXCLUIR_TAREFA,
    FILTRAR_TAREFA,
    SAIR
}


fun main() {
    val listaDeTasks = TaskManager()

    var acao: Int? = null
    while (acao != AcoesMenu.SAIR.ordinal) {
        println(
            """
            +---+---+------------------+
            |     LISTA DE TAREFAS     |
            +---+---+------------------+
            | 1  -  Adicionar tarefa   |
            | 2  -  Listar tarefas     |
            | 3  -  Buscar tarefa      |
            | 4  -  Atualizar status   |
            | 5  -  Excluir tarefa     |
            | 6  -  Filtrar tarefas    |
            | 7  -  Sair               |
            +---+---+------------------+
        """
        )
        println("Total de tarefas: ${listaDeTasks.count()}")
        println("Lista Atual de Tarefas:")
        println(
            listaDeTasks.listarTasks().joinToString(
                separator = "\n",
            ).ifEmpty { "Nenhuma tarefa foi cadastrada até o momento" })
        println("\nInsira a ação de controle de tarefa:")
        print("-> ")
        acao = readlnOrNull()?.toIntOrNull()

        when (acao) {
            AcoesMenu.ADICIONAR_TAREFA.ordinal -> {
                val tarefa = criarTarefa()
                val result = listaDeTasks.adicionarTask(tarefa)
                println(result)
            }

            AcoesMenu.LISTAR_TAREFA.ordinal -> {
                println("Tarefas:")
                println(listaDeTasks.listarTodasTasks().joinToString(
                    separator = "\n",
                ).ifEmpty { "Nenhuma tarefa foi cadastrada até o momento" })
            }

            AcoesMenu.BUSCAR_TAREFA.ordinal -> {
                val result = listaDeTasks.buscarTaskResult(lerIdValido("Insira o ID da tarefa a ser buscada:"))
                println(result)
            }

            AcoesMenu.ATUALIZAR_STATUS_TAREFA.ordinal -> {
                val result = listaDeTasks.completarTask(lerIdValido("Insira o ID da tarefa a ser concluida:"))
                println(result)
            }

            AcoesMenu.EXCLUIR_TAREFA.ordinal -> {
                val result = listaDeTasks.excluirTask(lerIdValido("Insira o ID da tarefa a ser deletada:"))
                println(result)
            }

            AcoesMenu.FILTRAR_TAREFA.ordinal -> {
                println("Tarefas Concluídas:")
                println(listaDeTasks.filtrarTarefasConcluidas()
                    .joinToString(separator = "\n") {it.toFormattedString()}
                    .ifEmpty { "Nenhuma tarefa concluida está cadastrada" })
                println("")
                println("Tarefas Pendentes:")
                println(listaDeTasks.filtrarTarefasPendentes()
                    .joinToString(separator = "\n") {it.toFormattedString()}
                    .ifEmpty { "Nenhuma tarefa pendente está cadastrada" })
            }

            AcoesMenu.SAIR.ordinal -> {
                println("Obrigado. Volte sempre")
            }

            AcoesMenu.DESCONHECIDA.ordinal -> {
                println("Opção escolhida é inválida. Tente novamente!")
            }

            else -> println("Opção escolhida é inválida. Tente novamente!")
        }

    }
}

fun criarTarefa(): Task {

    var title = ""
    println("Insira o titulo da tarefa:")
    while (title.isBlank()) {
        print("-> ")
        title = readln()
        if (title.isBlank()) {
            println("O titulo é inválido. Tente novamente.")
        }
    }

    var description: String? = null
    println("Insira a descrição da tarefa:")
    print("-> ")
    description = readln()
    description = description.ifBlank {
        null
    }

    return Task.create(title, description)
}

fun lerIdValido(mensagem: String): Int {
    var id: Int? = null
    println(mensagem)
    while (id.isNullOrNegative()) {
        print("-> ")
        id = readlnOrNull()?.toIntOrNull()
        if (id.isNullOrNegative()) {
            println("O ID inserido é inválido. Tente novamente.")
        }
    }
    return id!!
}