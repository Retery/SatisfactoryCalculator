import java.io.File

fun main(){
    items()


}
private fun recipe() {
    fun extracted() {
        val file = File("generate_recepi.txt")
        file.writeText("")
        println("Введтие количество рецептов")
        val numRepeat = readLine()!!.toInt()

        for (i in 1..numRepeat) {
            println("Введите id")
            val id = readLine()
            println("Введите имя")
            val name = readLine()
            println("1 - true")
            val isRaw = if (readLine() == "1") true else false
            file.appendText(
                """
      {
        "id": "$id",
        "name": "$name",
        "isRaw": $isRaw
      },
      
        """.trimIndent()
            )
        }
    }
}
private fun items() {
    fun extracted() {
        val file = File("example.txt")
        file.writeText("")
        println("Введтие количество рецептов")
        val numRepeat = readLine()!!.toInt()

        for (i in 1..numRepeat) {
            println("Введите id")
            val id = readLine()
            println("Введите имя")
            val name = readLine()
            println("1 - true")
            val isRaw = if (readLine() == "1") true else false
            file.appendText(
                """
      {
        "id": "$id",
        "name": "$name",
        "isRaw": $isRaw
      },
      
        """.trimIndent()
            )
        }
    }
}