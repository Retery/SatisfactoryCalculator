import kotlin.collections.forEach

fun printTree(
    node: ProductionNode,
    recipeService: RecipesService,
    prefix: String = "",
    isLast: Boolean = true
) {
    val connector = if (isLast) "└───" else "├───"
    val itemName = recipeService.getItem(node.id).name
    val machine = if(node.recipe!=null) recipeService.getMachine(node.recipe).
    replaceFirstChar { it.uppercase() } else "Miner"

    val scale = getScale(node,recipeService)
    val remainder = scale % 1 //Остаток для формулы потребления
    val number = scale - remainder

    println("$prefix$connector $itemName ($machine x $number + " +
            "${(remainder*100).toInt()+1}%) x${node.count}")

    val newPrefix = if (isLast)"$prefix    " else "$prefix|    "

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