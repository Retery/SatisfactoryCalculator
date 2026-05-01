import kotlin.collections.forEach
fun printTree(node: ProductionNode, prefix: String = "",isLast: Boolean = true) {

}
fun showCountDownloads(
    items: List<Item>,
    recipes: List<Recipe>
){
    println("Загружено предметов: ${items.size}")

    items.forEach { item ->
        println("id: ${item.id}, название: ${item.name},  базовый предмет: ${item.isRaw}")
    }

    println("Загружено рецептов: ${recipes.size}")
    recipes.forEach { recipe ->
        println("id: ${recipe.id}")
        println("Машина: ${recipe.machine}")
        println("Вход: ${recipe.input.joinToString { "${it.itemId} x ${it.amount}" }}")
        println("Выход: ${recipe.output.itemId} x ${recipe.output.amount}\n")
    }
}