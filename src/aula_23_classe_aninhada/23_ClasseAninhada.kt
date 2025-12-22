package aula_23_classe_aninhada

class Car (
    val model: String,
    val year: Int,
) {


    class Engine {

        class Fuel(val typeName: String) {

            fun fuelCar() {
                println("Abasatecendo o carro $typeName")
            }

        }

        fun start() {
            println("Ligando...")
        }

    }

}

fun main() {

    val car = Car("Honda Civic", 2007)
    val carEngine = Car.Engine()

    val engine = Car.Engine()

    val fuelType = Car.Engine.Fuel("Gasolina")

    carEngine.start()
    fuelType.fuelCar()


}