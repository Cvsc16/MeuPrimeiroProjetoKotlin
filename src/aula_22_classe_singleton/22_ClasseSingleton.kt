package aula_22_classe_singleton

object DatabaseUtil {

    val url: String = "jdbc:postgresql://localhost:8080/mydb"
    private val user: String = "admin"
    private val password: String = "admin"

    fun connect() {
        println("Conectando ao database $url | Usuário: $user | Senha: $password")
    }

}

data object DatabaseHelper {

}

fun main() {

    DatabaseUtil.connect()

    println(DatabaseUtil)
    println(DatabaseHelper)

}