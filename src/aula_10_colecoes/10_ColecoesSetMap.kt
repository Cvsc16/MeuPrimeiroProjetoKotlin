package aula_10_colecoes

fun main() {

    // set

    val set = setOf(1, 2, 3)

    val setRandom = setOf(1, 2, 3, "kotlin", "kotlin", "caio", 4.0, 5f, 0..100, 1, 2, 19, "kotlin2")

    val setMutable = mutableSetOf(1, 2, 3, "kotlin", "kotlin2", 4.0, 5.0)

    setMutable.add(10)
    setMutable.remove(1)

    println(setRandom)
    println(setMutable)

    // map

    val map = mapOf<Int, String>(Pair(1, "kotlin"), 1 to "kotlin", 2 to "kotlin2", 3 to "kotlin3")

    println(map)

}