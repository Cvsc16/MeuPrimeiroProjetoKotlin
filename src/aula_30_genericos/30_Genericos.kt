package aula_30_genericos

fun <T> printItem(item: T) {
    println(item)
}

data class Product(
    val name: String,
    val amount: Int,
)

class Container<T>(val items: List<T>) : ItemnsPrinter<T> {
    fun showItems() {
        println(
            """
                Itens do container:
                ${items.joinToString()}
            """.trimIndent()
        )
    }

    override fun printItem(item: T) {
        println("Item: $item")
    }
}

interface ItemnsPrinter<T> {
    fun printItem(item: T)
}

fun <T> List<T>.secondOrNull(): T? {
    return if (this.size >= 2) this[1] else null
}

fun <T: Comparable<T>> findMax(a: T, b: T): T {
    return if (a > b) a else b
}

fun main() {

    printItem("Koltin")

    printItem(true)

    printItem(2)

    printItem( object {
        val name: String = "Koltin"
        val x: Double = 100.0
    })

    val container1 = Container(listOf(
        Product("cerveja", 10),
        Product("bala", 20)))

    container1.showItems()

    val container2 = Container(listOf(
        "Laranja",
        "Maçã"
    ))

    container2.showItems()
    container2.printItem(container2.items.first())

    val productList = listOf(
        Product("cerveja", 10),
        Product("bala", 20))

    val productList2 = listOf(
        Product("cerveja", 10)
       )

    println(productList.secondOrNull())
    println(productList2.secondOrNull())

    println(findMax("hello", "kotlin"))
    println(findMax(10, 20))
}