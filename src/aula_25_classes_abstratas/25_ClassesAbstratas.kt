package aula_25_classes_abstratas

abstract class Vehicle(
    val color: String,
) {
    abstract val maxSpeed: Int
    abstract val wheelsAmount: Int

    abstract fun startMovement()

    fun info() {
        println("""
            Velocidade Máxima = $maxSpeed Km/h
            Quantidade de Rodas = $wheelsAmount
        """.trimIndent())
    }
}

class Car(
    val model: String,
    val year: Int,
    color: String) : Vehicle(color) {
    override val maxSpeed: Int
        get() = 150
    override val wheelsAmount: Int
        get() = 4

    override fun startMovement() {
        println("ligando motor...")
    }

    override fun toString(): String {
        super.info()
        return "$model, $year"
    }

}

class Bike(color: String) : Vehicle(color) {
    override val maxSpeed: Int
        get() = 40
    override val wheelsAmount: Int
        get() = 2

    override fun startMovement() {
        println("Pedalando...")
    }
}

fun main() {

    val car = Car(
        "Civic",
        2002,
        "Prata",
    )

    println(car)
    car.startMovement()

    val bike = Bike(
        "Vermelha",
    )

    println(bike.maxSpeed)
    println(bike.wheelsAmount)
    bike.info()
    bike.startMovement()

}