package aula_15_funcoes_extensao

fun String.isPalindrome(): Boolean {
    return this == this.reversed()
}

fun Double.format(decimalDigits: Int) : String {
    return "%.${decimalDigits}f".format(this)
}

fun main() {

    println("radar".isPalindrome())
    println("banana".isPalindrome())

    println(4.432432432434324.format(2))

}