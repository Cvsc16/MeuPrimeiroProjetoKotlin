package aula_31_variancia

open class Animal(
    val name: String,
)

class Dog : Animal("Cachorro")
class Cat : Animal("Gato")
class Bird : Animal("Pássaro")

// contravariância = in (consumidores)

class Feeder<in T: Animal> {
    fun feed(animal: T) {
        println("${animal.name} foi alimentado")
    }

}

// covariância = out (produtores)

open class Drink(
    val name: String,
)

class Juice : Drink(name = "Suco")
class Soda : Drink(name = "Refrigerante")
class Coffee : Drink(name = "Café")

class Cup<out T: Drink>(val drink: T, val amount: Int)

fun serveDrink(cup: Cup<Drink>) {
    println("Servindo a bebida ${cup.drink.name} de quantidade ${cup.amount} ml")
}

fun main() {

    val carFeeder = Feeder<Cat>()
    val dogFeeder = Feeder<Dog>()

    carFeeder.feed(animal = Cat())
    dogFeeder.feed(animal = Dog())

    serveDrink(cup = Cup<Coffee>(drink = Coffee(), amount = 100))
    serveDrink(cup = Cup<Juice>(drink = Juice(), amount = 300))
}