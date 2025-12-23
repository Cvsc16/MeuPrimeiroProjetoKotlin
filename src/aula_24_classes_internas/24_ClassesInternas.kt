package aula_24_classes_internas

import java.time.Year

class Car (
    val model: String,
    val year: Int
) {

    inner class Engine {

        inner class Fuel(
            val typeName: String
        ) {

            fun fuelCar() {
                println("Abastecendo o carro $model, $year com $typeName")
                start()
            }

        }

        fun start() {
            println("Ligando o carro de modelo $model e ano $year...")
        }

    }

}

fun main() {

    val carEngine = Car("Civic", 2007).Engine()
    val carEngineFuelType = carEngine.Fuel("Gasolina")

    carEngineFuelType.fuelCar()


}