package aula_27_interfaces

data class Document(
    val text: String,
)

interface Printer {
    fun print(text: String): Document

    val printerType: String
}

interface TextConverter {
    val defaultText: String
        get() = "Desconhecido"

    fun convert(text: String, printerType: String): String {
        return text.ifEmpty { defaultText }
    }
}

class PdfPrinter: Printer, TextConverter {
    override fun print(text: String): Document {
        convert(text, printerType)
        println("PDF printing: $text")
        return Document(text)
    }

    override val printerType: String
        get() = "PDF"

    override fun convert(text: String, printerType: String): String {
        println("Convertent texto '$text' para o tipo $printerType...")
        return text
    }

}

class WordPrinter: Printer, TextConverter {
    override fun print(text: String): Document {
        convert(text, printerType)
        println("Word printing: $text")
        return Document(text)
    }

    override val printerType: String
        get() = "WORD"

    override fun convert(text: String, printerType: String): String {
        println("Convertent texto '$text' para o tipo $printerType...")
        return text
    }

}

fun main() {

    val pdfPrinter = PdfPrinter()

    val pdfDocument: Document = pdfPrinter.print("Hello Kotlin!, from Pdf")

    println(pdfDocument)

    val wordPrinter = WordPrinter()

    val wordDocument: Document = wordPrinter.print("Hello Kotlin!, from Word")

    println(wordDocument)


}