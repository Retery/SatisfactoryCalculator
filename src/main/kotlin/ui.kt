import kotlin.collections.forEach

fun printTree(
    node: ProductionNode,
    recipeService: RecipesService,
    prefix: String = "",
    isLast: Boolean = true
) {
    val connector = if (isLast) "└──" else "├──"
    val itemName = recipeService.getItem(node.id).name
    //val machine = if ()
    println("$prefix$connector $itemName($) x${node.count}")
    val newPrefix = if (isLast)"$prefix   " else "$prefix|   "

    node.children.forEachIndexed { index, child ->
        val isLastChild = (index == node.children.lastIndex)
        printTree(child, recipeService, newPrefix, isLastChild)
    }
}

fun showCountDownloads(
    items: List<Item>,
    recipes: List<Recipe>
) {
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