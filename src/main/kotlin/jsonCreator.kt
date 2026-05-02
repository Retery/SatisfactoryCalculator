import java.io.File

fun main(){
    recipe()


}
private fun recipe() {
        val file = File("generate_recipe.txt")
        file.writeText("")
        println("Введтие количество рецептов")
        val numRepeat = readln().toInt()

        for (i in 1..numRepeat) {
            println("Введите id рецепта")
            val id = readLine()
            println("Введите имя рецепта")
            val name = readLine()

            file.appendText(
                """
    {
      "id": "$id",
      "name": "$name",
      "input": [
      
        """.trimIndent()
            )

            println("Введите количество ингридиентов:")
            val input = readln()
            val ingredientsCount = input.toIntOrNull() ?: 1
            for (i in 1..ingredientsCount){
                println("Введите id $i-го ингридиента:")
                val ingredientId = readlnOrNull()
                println("Введите количество $i-го ингридиента:")
                val ingredientCount = readlnOrNull()

                file.appendText(
                    """
          { 
                  "itemId":  "$ingredientId",
                  "amount": $ingredientCount
          }${if (ingredientsCount > 1 && i!=ingredientsCount) "," else ""}
          
        """.trimIndent())
            }
            println("Введите id выходного предмета:")
            val outputId = readln()
            println("Введите количество выходного предмета:")
            val outputCount = readln()
            file.appendText(
                """
    ],
      "output": {
        "itemId": "$outputId",
        "amount": $outputCount,
      },
      "machine": "constructor"
    },
        """.trimIndent())

        }
}
private fun items() {
        val file = File("generate_items.txt")
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