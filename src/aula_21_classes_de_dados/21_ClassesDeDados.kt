package aula_21_classes_de_dados

class UserClass(
    val name: String,
    val age: Int
)

data class UserDataClass(
    val name: String,
    val age: Int
)

fun main() {

    val userClass = UserClass("John", 35)
    val userDataClass = UserDataClass("John 2", 39)

    // toString

    println(userClass)
    println(userDataClass)

    // equals

    val jose = UserDataClass("Jose", 35)
    val jose2 = UserDataClass("Jose", 35)
    val maria = UserDataClass("Maria", 40)

    val userClass2 = userClass

    println(jose == jose2)
    println(userClass == userClass2)

    // copy

    val copyMaria = maria.copy(age = 10)

    println(copyMaria)

    val (name, age) = jose

    println("$name, $age")

}