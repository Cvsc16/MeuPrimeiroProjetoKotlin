package aula_29_classes_e_interfaces_seladas

sealed interface Animal {
    data class Dog(val breed: String) : Animal {
        override fun sound(): String {
            return "Au au!"
        }
    }

    data class Cat(val color: String) : Animal {
        override fun sound(): String {
            return "Miau!"
        }
    }

    data object Bird: Animal {
        override fun sound(): String {
            return "Piu!"
        }
    }

    fun sound(): String

}

sealed class Result {
    data class Success(val data: String) : Result()
    data class Error(val exception: Exception) : Result()
    data object Loading : Result()
}

fun handleResult(result: Result) {
    println(
        when (result) {
            is Result.Error -> "Houve um erro! ${result.exception.message}"
            Result.Loading -> "Carregando..."
            is Result.Success -> "Sucesso! ${result.data}"
        }
    )
}

fun handleAnimal(animal: Animal) {
    println(
        when (animal) {
            is Animal.Cat -> "O animal é um gato. O som que ele faz é ${animal.sound()} e sua cor é ${animal.color}"
            is Animal.Dog -> "O animal é um cachorro. O som que ele faz é ${animal.sound()} e sua raça é ${animal.breed}"
            is Animal.Bird -> "O animal é um passáro. O som que ele faz é ${animal.sound()}"
        }
    )
}

object Database {

    fun getContacts(): Result {
        return Result.Success(data = listOf("João", "José", "Maria").joinToString())
    }

    fun insertContact(contact: String): Result {
        return Result.Error(exception = IllegalArgumentException("O contato $contact a ser inserido possui caracteres inválidos"))
    }

    fun updateContact(id: Int, newContact: String): Result {
        return Result.Loading
    }

}

fun main() {

    val contacts: Result = Database.getContacts()
    val isContactInserted: Result = Database.insertContact("Caio")
    val isContactUpdated: Result = Database.updateContact(3, "Vitor")

    handleResult(contacts)
    handleResult(isContactInserted)
    handleResult(isContactUpdated)

    val dog = Animal.Dog("Poodle")
    val cat = Animal.Cat("Frajola")
    val bird = Animal.Bird

    handleAnimal(dog)
    handleAnimal(cat)
    handleAnimal(bird)

}