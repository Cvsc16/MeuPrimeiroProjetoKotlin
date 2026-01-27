package desafios

// 1) Estruturar a definição de produto = criar a
// data class Produto estruturar o estoque de produtos
// = class EstoqueDePordutos

// 2) Construir o menu (visualmente)

// 3) Funções de input de dados (int, double, string)

// 4) Lógica de execução de ações do menu

data class Produto(
    val id: Int,
    val nome: String,
    val preco: Double,
    val quantidade: Int
)

interface Estoque<T> {
    fun inserir(item: T)
    fun deletar(id: Int): Boolean
    fun atualizar(item: T): Boolean
    fun buscar(id: Int): T?
    fun buscarTodos(): List<T>
}

class EstoqueDeProdutos : Estoque<Produto> {

    private val listaProdutos = mutableListOf<Produto>()

    override fun inserir(item: Produto) {
        listaProdutos.add(item)
    }

    override fun deletar(id: Int): Boolean {
        return listaProdutos.removeIf { it.id == id }
    }

    override fun atualizar(item: Produto): Boolean {
        if (listaProdutos.removeIf { it.id == item.id }) {
            listaProdutos.add(item)
            return true
        } else {
            return false
        }

    }

    override fun buscar(id: Int): Produto? {
        return listaProdutos.find { it.id == id }
    }

    override fun buscarTodos(): List<Produto> {
        return listaProdutos.toList()
    }

}

fun preencherProdutoAtualizado(produtoASerAtualizado: Produto) : Produto {

    var nome: String? = null
    println("Altere o Nome do produto (caso não queria mudar, tecle ENTER):")
    while (nome.isNullOrEmpty()) {
        print("-> ")
        nome = readlnOrNull()?.ifEmpty { produtoASerAtualizado.nome }
        if (nome.isNullOrEmpty()) {
            println("O Nome inserido é inválido. Tente novamente.")
        }
    }

    var preco: Double? = null
    println("Altere o Preço do produto (caso não queria mudar, tecle ENTER):")
    while (preco.isNullOrNegative()) {
        print("-> R$ ")
        preco = readlnOrNull()?.ifEmpty { produtoASerAtualizado.preco.toString() }?.toDoubleOrNull()
        if (preco.isNullOrNegative()) {
            println("O Preço inserido é inválido. Tente novamente.")
        }
    }

    var quantidade: Int? = null
    println("Altere a Quantidade do produto (caso não queria mudar, tecle ENTER):")
    while (quantidade.isNullOrNegative()) {
        print("-> ")
        quantidade = readlnOrNull()?.ifEmpty { produtoASerAtualizado.quantidade.toString() }?.toIntOrNull()
        if (quantidade.isNullOrNegative()) {
            println("A Quantidade inserida é inválido. Tente novamente.")
        }
    }

    return Produto(
        id = produtoASerAtualizado.id,
        nome = nome,
        preco = preco!!,
        quantidade = quantidade!!
    )

}

fun preencherProduto() : Produto {

    var id: Int? = null
    println("Insira o ID do produto:")
    while (id.isNullOrNegative()) {
        print("-> ")
        id = readlnOrNull()?.toIntOrNull()
        if (id.isNullOrNegative()) {
            println("O ID inserido é inválido. Tente novamente.")
        }
    }

    var nome: String? = null
    println("Insira o Nome do produto:")
    while (nome.isNullOrEmpty()) {
        print("-> ")
        nome = readlnOrNull()
        if (nome.isNullOrEmpty()) {
            println("O Nome inserido é inválido. Tente novamente.")
        }
    }

    var preco: Double? = null
    println("Insira o Preço do produto:")
    while (preco.isNullOrNegative()) {
        print("-> R$ ")
        preco = readlnOrNull()?.toDoubleOrNull()
        if (preco.isNullOrNegative()) {
            println("O Preço inserido é inválido. Tente novamente.")
        }
    }

    var quantidade: Int? = null
    println("Insira a Quantidade do produto:")
    while (quantidade.isNullOrNegative()) {
        print("-> ")
        quantidade = readlnOrNull()?.toIntOrNull()
        if (quantidade.isNullOrNegative()) {
            println("A Quantidade inserida é inválido. Tente novamente.")
        }
    }

    return Produto(
        id = id!!,
        nome = nome,
        preco = preco!!,
        quantidade = quantidade!!
    )
}

fun Int?.isNullOrNegative(): Boolean {
    return this == null || this < 0
}

fun Double?.isNullOrNegative(): Boolean {
    return this == null || this < 0
}

enum class AcoesMenu {
    DESCONHECIDA,
    ADICIONAR_PRODUTO,
    ATUALIZAR_PRODUTO,
    DELETAR_PRODUTO,
    BUSCAR_PRODUTO,
    SAIR
}

fun main() {
    val estoqueDeProdutos = EstoqueDeProdutos()

    var acao: Int? = null
    while (acao != AcoesMenu.SAIR.ordinal) {
        // https://tableconvert.com/ascii-generator
        println(
            """
            +---------------------------------+
            |  CONTROLE DE ESTOQUE - PRODUTOS |
            +---------------------------------+
            |  1 - Adicionar                  |
            |  2 - Atualizar                  |
            |  3 - Deletar                    |
            |  4 - Buscar                     |
            |  5 - Sair                       |
            +---------------------------------+
        """
        )
        println("Lista Atual de Produtos em Estoque:")
        println(
            estoqueDeProdutos.buscarTodos().joinToString(
                separator = "\n",
            ).ifEmpty { "Nenhum produto foi adicionado ao estoque até o momento" })
        println("\nInsira a ação de controle de estoque:")
        print("-> ")
        acao = readlnOrNull()?.toIntOrNull()

        when (acao) {
            AcoesMenu.ADICIONAR_PRODUTO.ordinal -> {
                val produto = preencherProduto()
                estoqueDeProdutos.inserir(produto)
                println("O produto foi inserido com SUCESSO!")
            }
            AcoesMenu.ATUALIZAR_PRODUTO.ordinal -> {
                var id: Int? = null
                println("Insira o ID do produto a ser atualizado:")
                while (id.isNullOrNegative()) {
                    print("-> ")
                    id = readlnOrNull()?.toIntOrNull()
                    if (id.isNullOrNegative() || estoqueDeProdutos.buscar(id!!) == null) {
                        println("O ID inserido é inválido. Tente novamente.")
                    }
                }

                val produtoASerAtualizado = estoqueDeProdutos.buscar(id = id!!)
                produtoASerAtualizado?.let {
                    val produtoAtualizado = preencherProdutoAtualizado(it)
                    estoqueDeProdutos.atualizar(produtoAtualizado)
                    println("O produto foi atualziado com SUCESSO!")
                }

            }
            AcoesMenu.DELETAR_PRODUTO.ordinal -> {
                var id: Int? = null
                println("Insira o ID do produto a ser deletado:")
                while (id == null || id < 0) {
                    print("-> ")
                    id = readlnOrNull()?.toIntOrNull()
                    if (id == null || id < 0 || estoqueDeProdutos.buscar(id) == null) {
                        println("O ID inserido é inválido. Tente novamente.")
                    }
                }

                val produtoDeletado = estoqueDeProdutos.deletar(id)
                println(
                    if (produtoDeletado) "o produto foi deletado com SUCESSO!"
                    else "Não existe nenhum produto com esse ID."
                )

            }
            AcoesMenu.BUSCAR_PRODUTO.ordinal -> {
                var id: Int? = null
                println("Insira o ID do produto a ser buscado:")
                while (id == null || id < 0) {
                    print("-> ")
                    id = readlnOrNull()?.toIntOrNull()
                    if (id.isNullOrNegative() || estoqueDeProdutos.buscar(id!!) == null) {
                        println("O ID inserido é inválido. Tente novamente.")
                    }
                }

                val produtoBuscado = estoqueDeProdutos.buscar(id)
                println(
                    if (produtoBuscado != null) "o produto buscado é: $produtoBuscado"
                    else "Não existe nenhum produto com esse ID."
                )

            }
            5 -> {
                println("Obrigado. Volte sempre")
            }
            AcoesMenu.DESCONHECIDA.ordinal -> {
                println("Opção escolhida é inválida. Tente novamente!")
            }
        }

    }
}