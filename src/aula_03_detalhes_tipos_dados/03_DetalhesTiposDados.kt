package aula_03_detalhes_tipos_dados

fun main() {

    val age: Int = 20

    // adicionar meses em formato decimal ao inteiro da idade (converter idade em um tipo de dado numérico flutuante)

    var ageDouble: Double = age.toDouble()

    val monthPercent: Double = 1.0 / 12

    println("ageDouble = $ageDouble, monthPercent = $monthPercent")

    // 2 meses depois...

    ageDouble += 2 * monthPercent

    println("ageDouble updated = $ageDouble")

    // mostrar a idade em formato string com padrão "A idade é x anos."

    val ageString: String = ageDouble.toString()

    val ageText: String = "A idade é $ageString anos"
    //val ageText: String = "A idade é ${ageString.plus(" anos")}"

    println(ageText)

    println(ageText.uppercase())
    println(ageText.lowercase())

}