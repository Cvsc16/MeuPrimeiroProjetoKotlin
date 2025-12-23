package aula_26_classes_enumeradas

enum class Direction (val description: String) {
    NORTH(description = "Direção norte") { // 0
        override fun symbol(): Char {
            return '↑'
        }

        override val symbol: Char
            get() = '↑'
    },
    SOUTH(description = "Direção sul") { // 1
        override fun symbol(): Char {
            return '↓'
        }

        override val symbol: Char
            get() = '↓'
    },
    EAST(description = "Direção leste") { // 2
        override fun symbol(): Char {
            return '→'
        }

        override val symbol: Char
            get() = '→'
    },
    WEST(description = "Direção oeste") { // 3
        override fun symbol(): Char {
            return '←'
        }

        override val symbol: Char
            get() = '←'
    };

    companion object {
        fun sumDirection(firstDirection : Direction, secondDirection : Direction) {
            println(firstDirection.description)
            println(secondDirection.description)
        }
    }

    fun addDirection(direction : Direction) {
        println(this.description)
        println(direction.description)
    }

    abstract fun symbol(): Char
    abstract val symbol: Char
}

fun main() {

    val north = Direction.NORTH

//    println(north.ordinal)
//    println(north.name)
//    println(north.desciption)
//
//    north.addDirection(Direction.EAST)
//
//    Direction.sumDirection(firstDirection = Direction.SOUTH, secondDirection =  Direction.WEST)

    // entries

    Direction.entries.forEach { item ->
        println(item.symbol() + " | " + item.symbol)
    }

    // valueOf

 //   println(Direction.valueOf("SOUTH").ordinal)

}